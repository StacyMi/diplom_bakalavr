
import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;


public class DataBase {
	private static SessionFactory db;
	private void createSession() {
		db = new AnnotationConfiguration()
				.configure("/resourses/hibernate.cfg.xml")
				.addAnnotatedClass(myTable.class)
				.addAnnotatedClass(myTable2.class)
				.addAnnotatedClass(myTable3.class)
				.addAnnotatedClass(myTable4_IDhist.class)
				.buildSessionFactory();
	}
    public List <myTable4_IDhist> selectUsers(){
        if (db == null)
            createSession();
        Session session = db.openSession();
        //блок отлавливания ошибок
        try {
            Query query = session.createQuery("From myTable4_IDhist");
            List list = query.list();
            if (list.size() > 0){
                return list;
            }else {
                return null;
            }
			/*if (usersnils.size() == 0) {
				return "no data";
			} else {
				System.out.println("size = "+usersnils.size());
			}*/
        }catch (HibernateException e){
            e.printStackTrace();
        }finally{
            //закрываем сессию
            session.close();
        }
        return null;
    }

	public boolean selectAuth(String username, String password){
		if (db == null)
			createSession();
		Session session = db.openSession();
		//блок отлавливания ошибок
		try {

			Query query = session.createQuery("from myTable2 where username = :n and password = :p");
			query.setParameter("n", username);
			query.setParameter("p", password);



			List list = query.list();
			if (list.size() == 0) {
				return false;
			} else {
				return true;
			}

		}catch (HibernateException e){
			e.printStackTrace();
		}finally{
			//закрываем сессию
			session.close();
		}
		return false;
	}

    public List <myTable> selectUser(String lastname, String firstname, String patronymic){
		if (db == null)
			createSession();
		Session session = db.openSession();
		//блок отлавливания ошибок
		try {

			Query query = session.createQuery("from myTable where lastname = :l and firstname = :f and patronymic = :p");
			query.setParameter("l", lastname);
			query.setParameter("f", firstname);
			query.setParameter("p", patronymic);
			
			
			List list = query.list();
                return list;

		}catch (HibernateException e){
			e.printStackTrace();
		}finally{
			//закрываем сессию
			session.close();
		}
		return null;
	}

	public void insertUser(String lastname, String firstname, String patronymic, Date data_b, String snils ){
		if (db == null)
			createSession();
		Session session = db.openSession();
		//блок отлавливания ошибок
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			myTable table = new myTable();
			//table.setId(id);
			table.setLastname(lastname);
			table.setFirstname(firstname);
			table.setPatronymic(patronymic);
			table.setData_b(data_b);
			table.setSnils(snils);
			session.save(table);
			transaction.commit();
			
		}catch (HibernateException e){
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			}finally{
			//закрывем сессию
			session.close();
			//System.out.println("Сессия закрыта");
		}
		System.out.println("Пользователь успешно добавлен");
			
	}
	public void insertUser_auth(String login, String password){
		if (db == null)
			createSession();
		Session session = db.openSession();
		//блок отлавливания ошибок
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			myTable2 table = new myTable2();
			//table.setId(id);
			table.setUsername(login);
			table.setPassword(password);
			session.save(table);
			transaction.commit();

		}catch (HibernateException e){
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally{
			//закрывем сессию
			session.close();
			//System.out.println("Сессия закрыта");
		}
		System.out.println("Пользователь успешно добавлен");
	}

	public void insertHistory(String lastname, String firstname, String patronymic,
                              Date data_b, String sex, String snils, Date data_create, Boolean ok ){
		//java.sql.Date test = data_b;

		if (db == null) {
            //System.out.println("_______>0");
            createSession();
        }
		Session session = db.openSession();
		//блок отлавливания ошибок
		Transaction transaction = null;
        //java.sql.Date dataBirth = null;
		try {

          //  DateFormat formatSQL = new SimpleDateFormat("yyyy-MM-dd");
           // final String stringDate= formatSQL.format(data_create);
            //dataBirth = new java.sql.Date(formatSQL.parse(stringDate).getTime());
            java.sql.Date sqlDate2 = null;

            //System.out.println("_______>1");
            java.util.Date data1 = data_create;
            java.sql.Date sqlDate1 = new java.sql.Date(data1.getTime());

            if (data_b != null) {
                java.util.Date data2 = data_b;
                sqlDate2 = new java.sql.Date(data2.getTime());
                //System.out.println("_______>2");
            }
            transaction = session.beginTransaction();
			myTable3 table = new myTable3();
			//table.setId(id);
            //System.out.println("_______>3");
			table.setLastname(lastname);
			table.setFirstname(firstname);
			table.setPatronymic(patronymic);

			table.setData_b(sqlDate2);
			table.setSex(sex);
			table.setSnils(snils);
			table.setData_create(sqlDate1);
			table.setOk(ok);
            //System.out.println("_______>4");

			session.save(table);
            //System.out.println("_______>5");
			transaction.commit();

		}catch (HibernateException e){

			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
        //catch (ParseException e) {
          //  System.out.println(e.getStackTrace());
        //}
        finally{
			//закрывем сессию
			session.close();
			//System.out.println("Сессия закрыта");
		}

		System.out.println("Данные о запросе добавлены в историю!");

	}

	public void insertIDhist(String lastname, String firstname, String patronymic, String idhist){


		if (db == null) {
			createSession();
		}
		Session session = db.openSession();
		//блок отлавливания ошибок
		Transaction transaction = null;
		try {

			java.util.Date data_create = new Date();
			java.sql.Date sql_data_create = new java.sql.Date(data_create.getTime());

			transaction = session.beginTransaction();
			myTable4_IDhist table = new myTable4_IDhist();

			table.setLastname(lastname);
			table.setFirstname(firstname);
			table.setPatronymic(patronymic);
			table.setIdhist(idhist);
			table.setData_create(sql_data_create);

			session.save(table);
			transaction.commit();

		}catch (HibernateException e){

			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		finally{
			//закрывем сессию
			session.close();
		}
		System.out.println("Данные GetStatus добавлены в историю!");

	}
}