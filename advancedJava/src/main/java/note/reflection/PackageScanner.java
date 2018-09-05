package note.reflection;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Code copied from: https://github.com/ddopson/java-class-enumerator
 */
public class PackageScanner {
    private static void log(String msg) {
        System.out.println("ClassDiscovery: " + msg);
    }

    private static Class<?> loadClass(String className) {
        try {
            return Class.forName(className);
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException("Unexpected ClassNotFoundException loading class '" + className + "'");
        }
    }

    /**
     * Given a package name and a directory returns all classes within that directory
     * @param directory
     * @param pkgname
     * @return Classes within Directory with package name
     */
    public static List<Class<?>> processDirectory(File directory, String pkgname) {

        ArrayList<Class<?>> classes = new ArrayList<Class<?>>();

        log("Reading Directory '" + directory + "'");

        // Get the list of the files contained in the package
        String[] files = directory.list();
        for (int i = 0; i < files.length; i++) {
            String fileName = files[i];
            String className = null;

            // we are only interested in .class files
            if (fileName.endsWith(".class")) {
                // removes the .class extension
                className = pkgname + '.' + fileName.substring(0, fileName.length() - 6);
            }

            log("FileName '" + fileName + "'  =>  class '" + className + "'");

            if (className != null) {
                classes.add(loadClass(className));
            }

            //If the file is a directory recursively class this method.
            File subdir = new File(directory, fileName);
            if (subdir.isDirectory()) {
                classes.addAll(processDirectory(subdir, pkgname + '.' + fileName));
            }
        }
        return classes;
    }

    /**
     * Given a jar file's URL and a package name returns all classes within jar file.
     * @param resource
     * @param pkgname
     */
    public static List<Class<?>> processJarfile(URL resource, String pkgname) {
        List<Class<?>> classes = new ArrayList<Class<?>>();

        //Turn package name to relative path to jar file
        String relPath = pkgname.replace('.', '/');
        log("relative path: "+relPath);
        String resPath = resource.getPath();
        log("resource path: "+resPath);
        String jarPath = resPath.replaceFirst("[.]jar[!].*", ".jar").replaceFirst("file:", "");
        // jarPath = jarPath.replace(" ", "\\ ");
        log("Reading JAR file: '" + jarPath + "'");
        JarFile jarFile;

        try {
            jarFile = new JarFile(jarPath);
        }
        catch (IOException e) {
            throw new RuntimeException("Unexpected IOException reading JAR File '" + jarPath + "'", e);
        }

        //get contents of jar file and iterate through them
        Enumeration<JarEntry> entries = jarFile.entries();
        while(entries.hasMoreElements()) {
            JarEntry entry = entries.nextElement();

            //Get content name from jar file
            String entryName = entry.getName();
            String className = null;

            //If content is a class save class name.
            if(entryName.endsWith(".class") && entryName.startsWith(relPath)
                    && entryName.length() > (relPath.length() + "/".length())) {
                className = entryName.replace('/', '.').replace('\\', '.').replace(".class", "");
            }

            log("JarEntry '" + entryName + "'  =>  class '" + className + "'");

            //If content is a class add class to List
            if (className != null) {
                classes.add(loadClass(className));
            }
        }
        return classes;
    }

    public static List<String> scanMethods(List<String> classNames, List<String> matches, List<String> excludes) throws ClassNotFoundException {

        List<String> results = new ArrayList<>();
        for(String className: classNames){
            Class c = Class.forName(className);
            Method[] methods = c.getMethods();
            for(Method m: methods){
                String methodName = m.getName();
                boolean matched = false;
                for(String match: matches){
                    if(methodName.matches(match)){
                        matched = true;
                        break;
                    }
                }
                for(String match: excludes){
                    if(methodName.matches(match)){
                        matched = false;
                        break;
                    }
                }

                if(matched){
                    results.add(className+"."+methodName);
                }
            }
        }

        return results;
    }


    public static List<String> scanforMethods(List<Class<?>> classes, List<String> matches, List<String> excludes) throws ClassNotFoundException {

        List<String> results = new ArrayList<>();
        for(Class c: classes){
            Method[] methods = c.getMethods();
            for(Method m: methods){
                String methodName = m.getName();
                boolean matched = false;
                for(String match: matches){
                    if(methodName.matches(match)){
                        matched = true;
                        break;
                    }
                }
                for(String match: excludes){
                    if(methodName.matches(match)){
                        matched = false;
                        break;
                    }
                }

                if(matched){
                    results.add(c.getName()+"."+methodName);
                }
            }
        }

        return results;
    }

    public static void printList(List<String> list){
        for(String item: list){
            System.out.println(item);
        }
    }

    /**
     * Give a package this method returns all classes contained in that package
     * @param pkg
     */
    public static List<Class<?>> getClassesForPackage(Package pkg) {
        ArrayList<Class<?>> classes = new ArrayList<Class<?>>();

        //Get name of package and turn it to a relative path
        String pkgname = pkg.getName();
        String relPath = pkgname.replace('.', '/');

        // Get a File object for the package
        URL resource = ClassLoader.getSystemClassLoader().getResource(relPath);

        //If we can't find the resource we throw an exception
        if (resource == null) {
            throw new RuntimeException("Unexpected problem: No resource for " + relPath);
        }

        log("Package: '" + pkgname + "' becomes Resource: '" + resource.toString() + "'");

        //If the resource is a jar get all classes from jar
        if(resource.toString().startsWith("jar:")) {
            classes.addAll(processJarfile(resource, pkgname));
        }
        else {
            classes.addAll(processDirectory(new File(resource.getPath()), pkgname));
        }

        return classes;
    }

    public static void main(String[] arsg) throws ClassNotFoundException {
        Package pack = PackageScanner.class.getPackage();
        List<Class<?>> classes = PackageScanner.getClassesForPackage(pack);
        System.out.println("*********************************************************************");


//        List<String> classNames = new ArrayList<>();
//        List<Class<?>> classes = new ArrayList<>();
        List<String> matches = new ArrayList<>();
        List<String> excludes = new ArrayList<>();

        //classes
//        classes.add(ClassScanner.class);
        //class names
//        classNames.add("com.cgi.pce.integration.impl.AccountListDAOImpl");
        //matches
        matches.add("persist.*");
        matches.add("promoteStagingFiles.*");
        matches.add("remove.*");
        matches.add("delete.*");
        matches.add("save.*");
        matches.add("update.*");
        matches.add("saveLabel.*");
        matches.add("deleteLabel.*");
        matches.add("deleteLabels.*");
        //excludes
        matches.add(".*BatchNotification.*");
        matches.add(".*Calendar.*");
        matches.add(".*CampaignTracking.*");
        matches.add(".*ChangeLog.*");
        matches.add(".*ChangeLogSubscription.*");
        matches.add(".*Channel.*");
        matches.add(".*ChannelNotifThreshold.*");
        matches.add(".*Conso.*");
        matches.add(".*CustomerReminders.*");
        matches.add(".*Extension.*");
        matches.add(".*ExecInstanceDetail.*");
        matches.add(".*GeS.*");
        matches.add(".*Jso.*");
        matches.add(".*MessageSent.*");
        matches.add(".*MultiPromote.*");
        matches.add(".*NotifFormat.*");
        matches.add(".*NotifGroup.*");
        matches.add(".*Profile.*");
        matches.add(".*RegistrationTracker.*");
        matches.add(".*RemindersSent.*");
        matches.add(".*Reports.*");
        matches.add(".*Repository.*");
        matches.add(".*Security.*");
        matches.add(".*Stats.*");
        matches.add(".*TestProfile.*");
        matches.add(".*TrackingData.*");
        matches.add(".*XmlLookup.*");
        matches.add(".*ScheduledMessage.*");
        matches.add(".*CustomerExtdHist.*");
        matches.add(".*MediaSentExtdHist.*");
        matches.add(".*EventAuditExtdHist.*");

        List<String> results = PackageScanner.scanforMethods(classes,matches,excludes);
        for(String name : results){
            System.out.println(name);
        }
    }
}
