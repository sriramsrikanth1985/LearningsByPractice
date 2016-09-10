package test;

import java.io.PrintStream;
import java.util.ArrayList;
import org.custommonkey.xmlunit.*;
import org.w3c.dom.Node;

public class BillDataDifferenceListener
    implements DifferenceListener
{

    private static ArrayList IGNORE_XPATH;

    public BillDataDifferenceListener()
    {
    }

    public int differenceFound(Difference difference)
    {
        int r = 0;
        NodeDetail nd = difference.getTestNodeDetail();
        String xpath = nd.getXpathLocation();
        System.out.println((new StringBuilder("XPATH: ")).append(xpath).toString());
        System.out.println((new StringBuilder("VALUE: ")).append(nd.getValue()).toString());
        if(difference.isRecoverable() || IGNORE_XPATH.contains(xpath) || xpath.indexOf("documentheader") > -1 || xpath.indexOf("@eventID") > -1)
        {
            r = 1;
        }
        return r;
    }

    public void skippedComparison(Node node, Node node1)
    {
    }

    static 
    {
        IGNORE_XPATH = new ArrayList();
        IGNORE_XPATH.add("/gldata[1]/fileheader[1]/@startDate");
        IGNORE_XPATH.add("/billdata[1]/fileheader[1]/@startDate");
        IGNORE_XPATH.add("/billdata[1]/fileheader[1]/@snapshotDate");
    }
}

