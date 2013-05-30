/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package basilic;

import basilic.ui.UI;
//import basilic.log.Log;
import basilic.model.Group;
import basilic.model.Utilisateur;

import basilic.ui.FenetrePrincipale;






/**
 *
 * @author per_ewan
 */
public class Basilic {
/*
    private static DefaultLayoutManager dlm = new DefaultLayoutManager();
    private static Window win = new Window(15,2,50,20,true,"Un test de JCurses");
    private static Label lab2 = new Label("Test", new CharColor(CharColor.WHITE, CharColor.BLUE));
*/
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {



//        FenetrePrincipale fp = new FenetrePrincipale();
//        fp.show();

//
        UI ui = UI.getUI();


        //Log.getLogInformations();


        //System.out.println(new Group().getUtils().get(0).getNom());
        //System.out.println(new Group().getUtilisateur("Machin").getNom());


        
        //new Group().addUtilisateur(new Utilisateur("Bobette"));
        //new Group().removeUtilisateur(new Utilisateur("Ginette"));




/*

        Element racine = new Element("serveur");
        Document doc = new Document(racine);
        Element util = new Element("utilisateur");
        racine.addContent(util);
        Element nom = new Element("nom").setText("Bob");
        util.addContent(nom);
        Element bdd = new Element("bdd").addContent(new Element("mysql"));
        util.addContent(bdd);
        Element blog = new Element("blog").addContent(new Element("dotclear"));
        util.addContent(blog);


        XMLOutputter xo = new XMLOutputter();
        try {
            FileOutputStream fos = new FileOutputStream("/home/per_ewan/Stlenn/Mennadou/Basilic/resources/serveur.xml");
            xo.output(doc, fos);
        } catch(Exception e) {}
*/
     //   LinkedList<String> list = new LinkedList<String>();
        
        /*
         * RÉCUPÉRER LE RÉSULTAT D'UNE COMMANDE LINUX
         *

        try {
            Process pro = Runtime.getRuntime().exec("ls /home/per_ewan");
            java.io.InputStream is = pro.getInputStream();
            java.io.StringWriter writer = new java.io.StringWriter();
            java.io.InputStreamReader reader = new java.io.InputStreamReader(is);
            java.io.BufferedReader br = new java.io.BufferedReader(reader);
            String line = "";
            while(null!=(line=br.readLine())) {
                writer.write(line);
                writer.write("\n");
            }
            System.out.println(writer.toString());

        } catch (java.io.IOException e) {
            System.out.println(e.getMessage());
        }
        */



/*
 * CRÉATION D'UN ARBRE XML ET EXPORT VERS UN FICHIER AVEC DOM
 *
 *

        Document doc = null;
        DocumentBuilderFactory dbf = null;


        try {
            dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();
            doc = builder.newDocument(); // nécessite d'incorporer xml-commons-apis.jar
            Element racine = (Element) doc.createElement("serveur");
            doc.appendChild(racine);
            Element util = (Element) doc.createElement("utilisateur");
            racine.appendChild(util);
            Element nom = (Element) doc.createElement("nom");
            util.appendChild(nom);
            nom.appendChild(doc.createTextNode("Bob"));
            Element mysql = (Element) doc.createElement("mysql");
            util.appendChild(mysql);
            Element blog = (Element) doc.createElement("blog");
            util.appendChild(blog);
            Element dotc = (Element) doc.createElement("dotclear");
            blog.appendChild(dotc);


            //XMLSerializer ser = new XMLSerializer(System.out, new OutputFormat("xml", "UTF-8", true));
            DOMImplementationLS domils = (DOMImplementationLS) (doc.getImplementation()).getFeature("LS", "3.0");

            LSOutput lso = domils.createLSOutput();
            FileOutputStream fos = new FileOutputStream("/home/per_ewan/Stlenn/Mennadou/Basilic/resources/serveur.xml");
            lso.setByteStream((OutputStream)fos);
            LSSerializer ser = domils.createLSSerializer();
            ser.write(doc, lso);
            fos.close();


            
        } catch (Exception e) {
            e.printStackTrace();
        }
*/

/*
 * TRAITEMENT D'UN ARBRE XML AVEC SAX
 *


        String docXML = "<serveur>"
                + "<utilisateur>Tom</utilisateur>"
                + "<utilisateur>Bob</utilisateur>"
                + "<utilisateur>Ginette</utilisateur>"
                + "<utilisateur>Machin</utilisateur>"
                + "<utilisateur>Truc</utilisateur>"
                + "<utilisateur>Robert</utilisateur>"
                + "<utilisateur>Maurice</utilisateur>"
                + "<utilisateur>Quitter</utilisateur>"
                + "</serveur>";
        
        String parser = "org.apache.xerces.parsers.SAXParser";

        Handler handler = new Handler();
        try {
        XMLReader reader = XMLReaderFactory.createXMLReader(parser);
        reader.setContentHandler(handler);
        //reader.setErrorHandler((ErrorHandler) handler);
        reader.parse(new InputSource(new StringReader(docXML)));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


 *
 *
 * FENÊTRAGE AVEC JCURSES
 *

        win.setClosingChar(new InputChar('Q'));
        Label lab = new Label("Tapez <Q> pour quitter", new CharColor(CharColor.WHITE, CharColor.BLUE));

        Panel pan1 = new Panel();
        win.setRootPanel(pan1);
        dlm.bindToContainer(win.getRootPanel());
        dlm.addWidget(lab, 0, 0, 25, 10, WidgetsConstants.ALIGNMENT_TOP, WidgetsConstants.ALIGNMENT_LEFT);

        Iterator<String> i = handler.getUtilisateurs().iterator();

        int pos = 1;
        while(i.hasNext()) {
            Button b = new Button(i.next());
            b.addListener(new SelectUtil());
            dlm.addWidget(b, 0, pos, 25, 10, WidgetsConstants.ALIGNMENT_CENTER, WidgetsConstants.ALIGNMENT_LEFT);
            pos++;
        }
     
        win.show();


    }

    static class Handler implements ContentHandler {

        private String tag ="";
        private LinkedList<String> utilisateurs = new LinkedList<String>();
        

        public void characters(char[] ch, int start, int length) throws SAXException {
            String donnees = new String(ch, start, length);
            if(tag.equals("utilisateur")) {           
                utilisateurs.add(donnees);
            }
        }

        public void endDocument() throws SAXException {}

        public void endElement(String uri, String localName, String qName) throws SAXException {
            tag = "";
        }

        public void endPrefixMapping(String prefix) throws SAXException {}

        public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {}

        public void processingInstruction(String target, String data) throws SAXException {}

        public void setDocumentLocator(Locator locator) {}

        public void skippedEntity(String name) throws SAXException {}

        public void startDocument() throws SAXException {}

        public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
            tag = localName;
        }

        public void startPrefixMapping(String prefix, String uri) throws SAXException {}

        public LinkedList<String> getUtilisateurs () {
            
            return utilisateurs;
        }
    }

    static class SelectUtil implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            //Label l = new Label("truc");
            //dlm.addWidget(l, 0, 10, 25, 10, WidgetsConstants.ALIGNMENT_CENTER, WidgetsConstants.ALIGNMENT_LEFT);
            //win.setBorderColors(new CharColor(CharColor.BLACK, CharColor.RED));


            Button but = (Button) ae.getSource();

            CharColor rb = new CharColor(CharColor.BLACK, CharColor.RED);

            but.setColors(rb);

            but.setFocusedButtonColors(new CharColor(CharColor.BOLD, CharColor.YELLOW));


            Window win2 = new Window(70,2,50,20,true,"Test de test");
            
            win2.setVisible(true);
            win2.setClosingChar(new InputChar('Q'));
            dlm.unbindFromContainer();
            dlm.bindToContainer(win2.getRootPanel());
            dlm.addWidget(new Button("test"), 0, 0, 25, 1, WidgetsConstants.ALIGNMENT_CENTER, WidgetsConstants.ALIGNMENT_LEFT);

            //win.setVisible(false);


        }
        */
    }

}

