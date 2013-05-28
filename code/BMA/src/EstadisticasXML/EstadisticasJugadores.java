/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EstadisticasXML;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Clase EstadisticasJugadores que se encargará de crear y consultar el 
 * contenido del schema XML de nuestro sistema en formato BD.
 * @author Moises Gautier Gómez
 * @version 1.0
 */

/*
 ******************************************************************************
                   (c) Copyright 2013 
                   * 
                   * Moisés Gautier Gómez
                   * Julio Ros Martínez
                   * Francisco Javier Gómez del Olmo
                   * Francisco Santolalla Quiñonero
                   * Carlos Jesús Fernández Basso
                   * Alexander Moreno Borrego
                   * Jesús Manuel Contreras Siles
                   * Diego Muñoz Rio
 
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************
 */

public class EstadisticasJugadores {
    
    /*
     * Metodo consultor
     * @param cadenaTag Parámetro formal que se corresponde con la etiqueta 
     * interna (hija) de cada etiqueta padre del XML.
     * @param etiqEstadistica Parámetro formal que se corresponde con el
     * elemento padre de la etiqueta del XML.
     */
    
    private static String obtenerNodoValor(String cadenaTag, Element etiqEstadistica) {
        Node Valor = (Node)etiqEstadistica.getElementsByTagName(cadenaTag).item(0).getFirstChild();
        return Valor.getNodeValue();
    }
    
     public ArrayList<EstadisticasXML> obtenerPersonas(){
         
       ArrayList<EstadisticasXML> listaEstadisticas = new ArrayList<EstadisticasXML>();
       
       try{
           DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
           DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
           
           /*
            * Transformamos el XML en un tipo normalizado para nuestro
            * tratamiento en la clase de java.
            */
           
           Document doc = docBuilder.parse(new File("XML-BD/BD-Estadisticas.xml"));
           doc.getDocumentElement().normalize();
           
           /*
            * Seleccionamos el nodo padre (etiqueta padre) donde se encuetran
            * los datos para los nodos (etiquetas hijas) del schema XML.
            */
           
           NodeList nodosJugadores = doc.getElementsByTagName("estadisticasXML");
           
           /*
            * Mientras vayamos encontrando etiquetas estadisticaXML dentro
            * del schema XML las iremos procesando.
            */
           
           for(int i=0; i<nodosJugadores.getLength();i++){
               Node estadisticasXML = nodosJugadores.item(i);
               if(estadisticasXML.getNodeType()== Node.ELEMENT_NODE){
                   Element elto = (Element) estadisticasXML;
                   
                   /*
                    * Creamos las etiquetas o nodos hijos de la que 
                    * depende EstadisticasXML, para luego insertarlas
                    * en el schema XML.
                    */
                   
                   EstadisticasXML objJugadores = new EstadisticasXML();
                   objJugadores.setNombre(obtenerNodoValor("Nombre",elto));
                   objJugadores.setApellidos(obtenerNodoValor("Apellidos",elto));
                   objJugadores.setPuntos(Integer.parseInt(obtenerNodoValor("Puntos",elto)));
                   objJugadores.setTirosDeCampo(Double.parseDouble(obtenerNodoValor("TirosDeCampo",elto)));
                   objJugadores.setTirosLibres(Double.parseDouble(obtenerNodoValor("TirosLibres",elto)));
                   objJugadores.setTriples(Double.parseDouble(obtenerNodoValor("Triples",elto)));
                   objJugadores.setRebotesOfensivos(Integer.parseInt(obtenerNodoValor("RebotesOfensivos",elto)));
                   objJugadores.setRebotesDefensivos(Integer.parseInt(obtenerNodoValor("RebotesDefensivos",elto)));
                   objJugadores.setAsistencias(Integer.parseInt(obtenerNodoValor("Asistencias",elto)));
                   objJugadores.setRobos(Integer.parseInt(obtenerNodoValor("Robos",elto)));
                   objJugadores.setPerdidas(Integer.parseInt(obtenerNodoValor("Pérdidas",elto)));
                   objJugadores.setValoracion(Integer.parseInt(obtenerNodoValor("Valoración",elto)));
                   
                   listaEstadisticas.add(objJugadores);
               }
           }
       } catch (ParserConfigurationException parseE){
           JOptionPane.showMessageDialog(null, parseE.getMessage(), "" + "Error", JOptionPane.ERROR_MESSAGE);
       } catch (SAXException saxE){
           JOptionPane.showMessageDialog(null, saxE.getMessage(), "" + "Error", JOptionPane.ERROR_MESSAGE);
       } catch (IOException ioE){
           JOptionPane.showMessageDialog(null, ioE.getMessage(), ""+"Error", JOptionPane.ERROR_MESSAGE);
       }          
       return listaEstadisticas;
   }
     
     
     public void agregarPersona(EstadisticasXML estadisticas) throws TransformerConfigurationException, TransformerException
   {
       try{
           
           /*
            * Transformamos el XML en un tipo normalizado para nuestro
            * tratamiento en la clase de java.
            */
           
       DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
       DocumentBuilder docBuilder = docBuilder = docFactory.newDocumentBuilder();
       
        Document doc = docBuilder.parse(new File("XML-BD/BD-Estadisticas.xml"));
           
           // Preparamos el archivo xml para obtener los datos.
        
          doc.getDocumentElement().normalize();
          
          // Obtenemos el nodo padre "BD-Estadisticas".
          
          Node nodoRaiz = doc.getDocumentElement();
          
          /*
           * Agregamos una nueva etiqueta al documento primero creamos 
           * la etiqueta.
          */
          
          Element nuevaEstadisticas = doc.createElement("estadisticas");
          
          // Creamos sus etiquetas hijas (nonmbre, apellidos, etc)
          
          Element nuevoNombre = doc.createElement("Nombre");
          nuevoNombre.setTextContent(estadisticas.getNombre());
          
          /* Agregamos contenido desde el objeto estadisticas */
          
          // hacemos esto con todas las etiquetas de estadisticas
          
          Element nuevoApellidos = doc.createElement("Apellidos");
          nuevoApellidos.setTextContent(estadisticas.getApellidos()); 
          
          /* De esta manera agregamos contenido
           * a las etiquetas hijas de "estadisticas" 
           */
                 
          Element nuevoPuntos = doc.createElement("Puntos");
          nuevoPuntos.setTextContent(""+estadisticas.getPuntos());
          
          Element nuevoTirosDeCampo = doc.createElement("TirosDeCampo");
          nuevoTirosDeCampo.setTextContent(""+estadisticas.getTirosDeCampo());
                 
          Element nuevoTirosLibres = doc.createElement("TirosLibres");
          nuevoTirosLibres.setTextContent(""+estadisticas.getTirosLibres());
          
          Element nuevoTriples = doc.createElement("Triples");
          nuevoTriples.setTextContent(""+estadisticas.getTriples());
          
          Element nuevoRebotesOfensivos = doc.createElement("RebotesOfensivos");
          nuevoRebotesOfensivos.setTextContent(""+estadisticas.getRebotesOfensivos());
   
          Element nuevoRebotesDefensivos = doc.createElement("RebotesDefensivos");
          nuevoRebotesDefensivos.setTextContent(""+estadisticas.getRebotesDefensivos());
          
          Element nuevoAsistencias = doc.createElement("Asistencias");
          nuevoAsistencias.setTextContent(""+estadisticas.getAsistencias());
          
          Element nuevoRobos = doc.createElement("Robos");
          nuevoRobos.setTextContent(""+estadisticas.getRobos());
          
          Element nuevoPerdidas = doc.createElement("Perdidas");
          nuevoPerdidas.setTextContent(""+estadisticas.getPerdidas());
          
          Element nuevoValoracion = doc.createElement("Valoracion");
          nuevoValoracion.setTextContent(""+estadisticas.getValoracion());
          
          // agregamos las etiquetas hijas de estadisticas
          
          nuevaEstadisticas.appendChild(nuevoNombre);
          nuevaEstadisticas.appendChild(nuevoApellidos);
          nuevaEstadisticas.appendChild(nuevoPuntos);
          nuevaEstadisticas.appendChild(nuevoTirosDeCampo);
          nuevaEstadisticas.appendChild(nuevoTirosLibres);
          nuevaEstadisticas.appendChild(nuevoTriples);
          nuevaEstadisticas.appendChild(nuevoRebotesOfensivos);
          nuevaEstadisticas.appendChild(nuevoRebotesDefensivos);
          nuevaEstadisticas.appendChild(nuevoAsistencias);
          nuevaEstadisticas.appendChild(nuevoRobos);
          nuevaEstadisticas.appendChild(nuevoPerdidas);
          nuevaEstadisticas.appendChild(nuevoValoracion);
          
          // ahora solo falta relacionarlas con una etiqueta ya existente en el documento
          // en este caso será nodoRaíz (la etiqueta prueba)
          
          nodoRaiz.appendChild(nuevaEstadisticas);
          
          // ahora transformaremos esta estructura de datos en un archivo XML
          
          TransformerFactory transFactory = TransformerFactory.newInstance();
          Transformer transformer = transFactory.newTransformer();
          DOMSource source = new DOMSource(doc);
          StreamResult result = new StreamResult(new File("XML-BD/BD-Estadisticas.xml"));
          transformer.transform(source, result);
          
          
          
       } catch (ParserConfigurationException parseE){
           System.out.println(parseE.getMessage());
       } catch (SAXException saxE) {
           System.out.println(saxE.getMessage());
       } catch (IOException ex) {
           System.out.println(ex.getMessage());
       }
       
       
       
       
   }
}
