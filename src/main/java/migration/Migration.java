package migration;

import configuration.MigrationConfig;
import migrator.GraknMigrator;
import static util.Util.getAbsPath;

import java.io.*;

public class Migration {

    private static final String schema = getAbsPath("src/main/resources/schema.gql");
    private static final String processorConfig = getAbsPath("src/main/resources/processorConfig.json");
    private static final String dataConfig = getAbsPath("src/main/resources/dataConfig.json");
    private static final String migrationStatus = getAbsPath("src/main/resources/migrationStatus.json");

    private static final String graknURI = "127.0.0.1:48555";
    private static final String keyspaceName = "grami_example";

    private static final MigrationConfig migrationConfig = new MigrationConfig(graknURI, keyspaceName, schema, dataConfig, processorConfig);

    public static void main(String[] args) throws IOException {
        GraknMigrator mig = new GraknMigrator(migrationConfig, migrationStatus, true);
        mig.migrate(true, true);
    }

}
