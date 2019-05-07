package resource;

/**
 * https://stackoverflow.com/questions/573679/open-resource-with-relative-path-in-java
 *
 * In the hopes of providing additional information for those who don't pick this up as quickly as others,
 * I'd like to provide my scenario as it has a slightly different setup.
 * My project was setup with the following directory structure (using Eclipse):
 *
 * Project/
 *   src/                // application source code
 *     org/
 *       myproject/
 *         MyClass.java
 *   test/               // unit tests
 *   res/                // resources
 *     images/           // PNG images for icons
 *       my-image.png
 *     xml/              // XSD files for validating XML files with JAXB
 *       my-schema.xsd
 *     conf/             // default .conf file for Log4j
 *       log4j.conf
 *   lib/                // libraries added to build-path via project settings
 *
 * I was having issues loading my resources from the res directory.
 * I wanted all my resources separate from my source code (simply for managment/organization purposes).
 * So, what I had to do was add the res directory to the build-path and then access the resource via:
 *
 * static final ClassLoader loader = MyClass.class.getClassLoader();
 *
 * // in some function
 * loader.getResource("images/my-image.png");
 * loader.getResource("xml/my-schema.xsd");
 * loader.getResource("conf/log4j.conf");
 */
public class Loader {


}
