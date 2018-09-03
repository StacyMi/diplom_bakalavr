package xml_GetStatus;

import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;

public class Header {
    public Element createHeader(Element root) {
        Element header = root.addElement("soap:Header");
            Element Security = header.addElement(new QName("Security", new Namespace("wsse","http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd")));
            Security.addNamespace("SOAP-ENV","http://schemas.xmlsoap.org/soap/envelope/");
            Security.addNamespace("wsu", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");
            Security.addAttribute("SOAP-ENV:actor", "http://smev.gosuslugi.ru/actors/smev");
                Element BinarySecurityToken = Security.addElement("wsse:BinarySecurityToken ");
                BinarySecurityToken.addAttribute("EncodingType", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary");
                BinarySecurityToken.addAttribute("ValueType", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-x509-token-profile-1.0#X509v3");
                BinarySecurityToken.addAttribute("wsu:Id","Cert");
                BinarySecurityToken.addText("PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz4NCjxzb2FwOkVudmVsb3BlIHhtbG5zOnNvYXA9Imh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3NvYXAvZW52ZWxvcGUvIj4NCiAgIDxzb2FwOkhlYWRlciAvPg0KICAgPHNvYXA6Qm9keSB4bWxuczp3c3U9Imh0dHA6Ly9kb2NzLm9hc2lzLW9wZW4ub3JnL3dzcy8yMDA0LzAxL29hc2lzLTIwMDQwMS13c3Mtd3NzZWN1cml0eS11dGlsaXR5LTEuMC54c2QiIHdzdTpJZD0iYm9keSI+DQogICAgICA8bnM0OmNyZWF0ZVJlcXVlc3RSZXF1ZXN0IHhtbG5zOm5zND0iaHR0cDovL3BvcnRhbC5mY2NsYW5kLnJ1L3J0LyIgeG1sbnM9Imh0dHA6Ly9zbWV2Lmdvc3VzbHVnaS5ydS9yZXYxMTExMTEiIHhtbG5zOm5zMj0iaHR0cDovL3BvcnRhbC5mY2NsYW5kLnJ1L3R5cGVzLyIgeG1sbnM6bnMzPSJodHRwOi8vd3d3LnczLm9yZy8yMDA0LzA4L3hvcC9pbmNsdWRlIj4NCiAgICAgICAgIDxNZXNzYWdlPg0KICAgICAgICAgICAgPFNlbmRlcj4NCiAgICAgICAgICAgICAgIDxDb2RlPkZNUzAwMTAwMTwvQ29kZT4NCiAgICAgICAgICAgICAgIDxOYW1lPtCk0JzQoTwvTmFtZT4NCiAgICAgICAgICAgIDwvU2VuZGVyPg0KICAgICAgICAgICAgPFJlY2lwaWVudD4NCiAgICAgICAgICAgICAgIDxDb2RlPlJSVFIwMTAwMTwvQ29kZT4NCiAgICAgICAgICAgICAgIDxOYW1lPtCg0L7RgdGA0LXQtdGB0YLRgDwvTmFtZT4NCiAgICAgICAgICAgIDwvUmVjaXBpZW50Pg0KICAgICAgICAgICAgPE9yaWdpbmF0b3I=");

                Element Signature = Security.addElement(new QName("Signature", new Namespace("ds","http://www.w3.org/2000/09/xmldsig#")));
                    Element SignedInfo = Signature.addElement("ds:SignedInfo");
                        Element CanonicalizationMethod = SignedInfo.addElement("ds:CanonicalizationMethod");
                        CanonicalizationMethod.addAttribute("Algorithm", "http://www.w3.org/2001/10/xml-exc-c14n#");

                        Element SignatureMethod = SignedInfo.addElement("ds:SignatureMethod");
                        SignatureMethod.addAttribute("Algorithm", "http://www.w3.org/2001/04/xmldsig-more#gostr34102001-gostr3411");

                        Element Reference = SignedInfo.addElement("ds:Reference");
                        Reference.addAttribute("URI", "#body");
                            Element Transforms = Reference.addElement("ds:Transforms");
                                Element Transform = Transforms.addElement("ds:Transforms");
                                Transform.addAttribute("Algorithm","http://www.w3.org/2001/10/xml-exc-c14n#");
                            Element DigestMethod = Reference.addElement("ds:DigestMethod");
                            DigestMethod.addAttribute("Algorithm", "http://www.w3.org/2001/04/xmldsig-more#gostr3411");
                            Element DigestValue = Reference.addElement("ds:DigestValue");
                            DigestValue.addText("CxgE5enquUmaf95Fxrmh8Chwa8ZVx2xmXX+HEa3Ihs4=");
                    Element SignatureValue = Signature.addElement("ds:SignatureValue");
                    SignatureValue.addText("evOXfx/aqjElVB33FPpi7u0RrEj4BOcnq3QxWs0QaUi0BJOgYTMCIOznrViKfmTmFUPmmv9XGU6jfRONlg35Iw==");
                    Element KeyInfo = Signature.addElement("ds:KeyInfo");
                        Element SecurityTokenReference = KeyInfo.addElement("wsse:SecurityTokenReference");
                            Element Reference2 = SecurityTokenReference.addElement("wsse:Reference");
                            Reference2.addAttribute("URI", "#Cert");
                            Reference2.addAttribute("ValueType","http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-x509-token-profile-1.0#X509v3");


        return root;
    }
}
