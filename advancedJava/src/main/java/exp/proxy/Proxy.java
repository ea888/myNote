package com.chandler.exp.proxy;

import java.io.*;
import java.net.Inet4Address;
import java.net.UnknownHostException;

public class Proxy {

    private boolean intranet = false;

    public Proxy() throws UnknownHostException {
        String ip = Inet4Address.getLocalHost().getHostAddress();
        if (ip.startsWith("172.24") || ip.startsWith("10.21.214")) {
            this.intranet = true;
        } else {
            this.intranet = false;
        }
    }

    public void editGitProxy() throws IOException, InterruptedException {
        String bypassHttpProxy = "git config --global http.\"http://aial2261.belldev.dev.bce.ca/\".proxy \"\"";
        String bypassHttpsProxy = "git config --global https.\"https://aial2261.belldev.dev.bce.ca/\".proxy \"\"";
        String httpProxy = "git config --global http.proxy \"http://142.182.19.14:80\"";
        String httpsProxy = "git config --global https.proxy \"https://142.182.19.14:80\"";

        String noHttpProxy = "git config --global --remove-section http";
        String noHttpsProxy = "git config --global --remove-section https";
        if (this.intranet) {
            Runtime.getRuntime().exec(bypassHttpProxy).waitFor();
            Runtime.getRuntime().exec(bypassHttpsProxy).waitFor();
            Runtime.getRuntime().exec(httpProxy).waitFor();
            Runtime.getRuntime().exec(httpsProxy).waitFor();
        } else {
            Runtime.getRuntime().exec(noHttpProxy).waitFor();
            Runtime.getRuntime().exec(noHttpsProxy).waitFor();
        }
    }

    public void editMavenProxy(String path) throws IOException {
        File settings = new File(path);
        String search, replacement;
        if (this.intranet) {
            search = "<active>false";
            replacement = "<active>true";
        } else {
            search = "<active>true";
            replacement = "<active>false";
        }

        String s;
        String totalStr = "";
        FileWriter fw = null;
        try (FileReader fr = new FileReader(settings); BufferedReader br = new BufferedReader(fr);) {

            while ((s = br.readLine()) != null) {
                totalStr += s;
            }
            totalStr = totalStr.replaceAll(search, replacement);
            fw = new FileWriter(settings);
            fw.write(totalStr);
        } finally {
            fw.close();
        }
    }

    public static void main(String args[]) {
        Proxy proxy = null;

        try {
            proxy = new Proxy();
            proxy.editGitProxy();
            proxy.editMavenProxy("C:\\Users\\qian.zhu\\.m2\\settings.xml");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
