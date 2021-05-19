package th.in.lordgift;

import org.apache.tools.ant.types.Path;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.reveng.dialect.MetaDataDialect;
import org.hibernate.tool.ant.Hbm2JavaExporterTask;
import th.in.lordgift.config.ConfigurationAwareToolTask;
import th.in.lordgift.config.ExtendedJDBCConfigurationTask;
import th.in.lordgift.config.ExtendedJDBCMetaDataConfigration;
import th.in.lordgift.exporter.Hbm2JavaExporterTaskHelper;

import java.io.File;

/**
 * Created by sunilp on 9/7/15.
 */
public class Hbm2JavaDemo {

    /* ABSOLUTE PATH also available */
    private static final String hibernateCfgXml     = "src/main/resources/sqlserver/hibernate.cfg.xml";
    private static final String outputDirectory     = "build/hbm2java/";
    private static final String outputPackage       = "model.entity";
    private static final String hibernateRevengXml  = "src/main/resources/sqlserver/hibernate.reveng.xml";

    public static void main(String[] args) {
        try {
            File configFile = new File(hibernateCfgXml);
            Configuration configuration = getJDBCConfiguration(configFile);
            ConfigurationAwareToolTask configurationAwareToolTask = new ConfigurationAwareToolTask(configuration);
            MetaDataDialect metaDataDialect = ((ExtendedJDBCMetaDataConfigration) configuration).getConfiguredMetaDataDialect();

            Hbm2JavaExporterTask hbm2javaExporter = new Hbm2JavaExporterTaskHelper(configurationAwareToolTask, metaDataDialect);
            hbm2javaExporter.setEjb3(true);
            hbm2javaExporter.setJdk5(true);
            hbm2javaExporter.setDestdir(new File(outputDirectory));
            hbm2javaExporter.execute();

            System.out.println("Output directory is >> " + hbm2javaExporter.getDestdir().getAbsolutePath());
            System.out.println("Successfully execution...");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }

    public static Configuration getJDBCConfiguration(File configFile)
    {
        ExtendedJDBCConfigurationTask jdbcConfiguration = new ExtendedJDBCConfigurationTask(configFile);
        jdbcConfiguration.setPackageName(outputPackage);
        jdbcConfiguration.setDetectOptimisticLock(false);
        jdbcConfiguration.setReverseStrategy("org.hibernate.cfg.reveng.DelegatingReverseEngineeringStrategy");

        Path path = new Path(null);
        path.setPath(hibernateRevengXml);
        jdbcConfiguration.setRevEngFile(path);

        return jdbcConfiguration.getConfiguration();
    }


}
