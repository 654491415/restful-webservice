/**
 * Copyright (c) 2019 ucsmy.com, All rights reserved.
 */
package javax.core.common.encrypt;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

/**
 * @Description:
 * @Author: Administrator
 * @Created Date: 2019年07月16日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version:
 */
public class XmlToBeanUtil {
    public static void main(String[] args) {
        String str ="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<ns2:eipOrderDtoArray xmlns:ns2=\"http://service.oto.webservice.sinotrans.com/\">\n" +
                "    <item>\n" +
                "        <eipodWbNo>SUNYIK16000462</eipodWbNo>\n" +
                "        <eipCtnInfoDto>\n" +
                "            <eipciCtnNo>CRXU1827795</eipciCtnNo>\n" +
                "            <eipciReleaseFlag>1</eipciReleaseFlag>\n" +
                "        </eipCtnInfoDto>\n" +
                "        <eipCtnInfoDto>\n" +
                "            <eipciCtnNo>SNCU2804504</eipciCtnNo>\n" +
                "            <eipciReleaseFlag>1</eipciReleaseFlag>\n" +
                "        </eipCtnInfoDto>\n" +
                "        <eipCtnInfoDto>\n" +
                "            <eipciCtnNo>TRHU2763145</eipciCtnNo>\n" +
                "            <eipciReleaseFlag>1</eipciReleaseFlag>\n" +
                "        </eipCtnInfoDto>\n" +
                "        <eipCtnInfoDto>\n" +
                "            <eipciCtnNo>SNBU2191230</eipciCtnNo>\n" +
                "            <eipciReleaseFlag>1</eipciReleaseFlag>\n" +
                "        </eipCtnInfoDto>\n" +
                "        <eipCtnInfoDto>\n" +
                "            <eipciCtnNo>GESU1231360</eipciCtnNo>\n" +
                "            <eipciReleaseFlag>1</eipciReleaseFlag>\n" +
                "        </eipCtnInfoDto>\n" +
                "        <eipCtnInfoDto>\n" +
                "            <eipciCtnNo>WSDU2149457</eipciCtnNo>\n" +
                "            <eipciReleaseFlag>1</eipciReleaseFlag>\n" +
                "        </eipCtnInfoDto>\n" +
                "        <eipCtnInfoDto>\n" +
                "            <eipciCtnNo>TGHU1697598</eipciCtnNo>\n" +
                "            <eipciReleaseFlag>1</eipciReleaseFlag>\n" +
                "        </eipCtnInfoDto>\n" +
                "        <eipCtnInfoDto>\n" +
                "            <eipciCtnNo>GVCU2288125</eipciCtnNo>\n" +
                "            <eipciReleaseFlag>1</eipciReleaseFlag>\n" +
                "        </eipCtnInfoDto>\n" +
                "        <eipCtnInfoDto>\n" +
                "            <eipciCtnNo>GESU3621259</eipciCtnNo>\n" +
                "            <eipciReleaseFlag>1</eipciReleaseFlag>\n" +
                "        </eipCtnInfoDto>\n" +
                "        <eipCtnInfoDto>\n" +
                "            <eipciCtnNo>UETU2279920</eipciCtnNo>\n" +
                "            <eipciReleaseFlag>1</eipciReleaseFlag>\n" +
                "        </eipCtnInfoDto>\n" +
                "    </item>\n" +
                "    <item>\n" +
                "        <eipodWbNo>SUNYIK19004202RS</eipodWbNo>\n" +
                "        <eipCtnInfoDto>\n" +
                "            <eipciCtnNo>UETU5137003</eipciCtnNo>\n" +
                "            <eipciReleaseFlag>1</eipciReleaseFlag>\n" +
                "        </eipCtnInfoDto>\n" +
                "    </item>\n" +
                "</ns2:eipOrderDtoArray>";



    }


    public static <T> T converyToJavaBean(String xml, Class<T> c) {
        T t = null;
        try {
            JAXBContext context = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            t = (T) unmarshaller.unmarshal(new StringReader(xml));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return t;
    }


}