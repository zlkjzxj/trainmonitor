package com.zlkj.trainmonitor.test;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WriteIniFile {
    static Map<String, Map<String, Object>> iniFile = new HashMap<String, Map<String, Object>>();


    public void write(String name) throws IOException {
        StringBuilder sb = new StringBuilder("");
        for (String section : iniFile.keySet()) {
            sb.append("[").append(section).append("]").append("\r\n");
            Map<String, Object> map = iniFile.get(section);

            Set<String> keySet = map.keySet();
            for (String key : keySet) {
                sb.append(key).append("=").append(map.get(key)).append("\r\n");
            }
        }
        File file = new File(name);
        if (!file.exists()) {
            file.createNewFile();
        }
        try {
            OutputStream os = new FileOutputStream(file);
            os.write(sb.toString().getBytes());
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setValue(String section, String key, Object value) {
        Map<String, Object> sectionMap = iniFile.get(section);
        if (sectionMap == null) {
            sectionMap = new HashMap<String, Object>();
            iniFile.put(section, sectionMap);
        }
        sectionMap.put(key, value);
    }

    public Object getValue(String section, String key) {
        Object obj = null;
        Map<String, Object> item = iniFile.get(section);
        if (item != null) {
            obj = item.get(key);
        }
        return obj;

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        WriteIniFile tools = new WriteIniFile();
//        tools.setValue("ip", "ip_address", "183.126.125.152");
//        tools.setValue("ip1", "ip_address1", "184.126.125.152");
//        try {
//            tools.write("E:\\NET.ini");
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        tools.setValue("ip1","fuck","shit");
        tools.getValue("ip1", "ip_address");
    }

}
