package test;

import java.io.*;
import org.custommonkey.xmlunit.*;

public class XMLCompare extends XMLTestCase
{

    String myControlXML;
    String myTestXML;

    public XMLCompare(String name)
    {
        super(name);
    }

    public static void main(String args[])
    {
        try
        {
            String xml1 = "C:\\Users\\ssriram\\Desktop\\XMLCompare\\BD_REG_1_610_3_197_100320000134700.xml";//args[0];
            String xml2 = "C:\\Users\\ssriram\\Desktop\\XMLCompare\\BD_REG_1_610_3_197.xml";//args[1];
            XMLCompare xmlc = new XMLCompare("TestXML");
            xmlc.setFiles(xml1, xml2);
            xmlc.isIdentical();
            System.out.println("[IDENTICAL]");
        }
        catch(Throwable e)
        {
            System.out.println("[DIFFERENT]");
            e.printStackTrace();
        }
    }

    public void setFiles(String xmlPath1, String xmlPath2)
        throws IOException
    {
        myControlXML = readFile(xmlPath1);
        myTestXML = readFile(xmlPath2);
    }

    private String readFile(String filepath)
        throws IOException
    {
        StringBuilder b = new StringBuilder(5000);
        BufferedReader buf = new BufferedReader(new FileReader(filepath));
        do
        {
            String line = buf.readLine();
            if(line != null)
            {
                b.append(line);
            } else
            {
                return b.toString();
            }
        } while(true);
    }

    public void isEqual()
        throws Exception
    {
        assertXMLEqual("comparing test xml to control xml", myControlXML, myTestXML);
        assertXMLNotEqual("test xml not similar to control xml", myControlXML, myTestXML);
    }

    public void isIdentical()
        throws Exception
    {
        Diff myDiff = new Diff(myControlXML, myTestXML);
        org.custommonkey.xmlunit.DifferenceListener myDiffListener = new BillDataDifferenceListener();
        myDiff.overrideDifferenceListener(myDiffListener);
        assertTrue((new StringBuilder()).append("pieces of XML are similar ").append(myDiff).toString(), myDiff.similar());
        assertTrue((new StringBuilder()).append("but are they identical? ").append(myDiff).toString(), myDiff.identical());
    }

    public String getAllDifferences()
        throws Exception
    {
        DetailedDiff myDiff = new DetailedDiff(compareXML(myControlXML, myTestXML));
        org.custommonkey.xmlunit.DifferenceListener myDiffListener = new BillDataDifferenceListener();
        myDiff.overrideDifferenceListener(myDiffListener);
        java.util.List allDifferences = myDiff.getAllDifferences();
        return myDiff.toString();
    }
}
