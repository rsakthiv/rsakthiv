package constants;

import java.io.File;

import utils.FileOperations;

public interface AppConfigData {

	/** FILE PATH **/
	String USER_DIR = System.getProperty("user.dir");

	String APP_CONFIG_PATH = USER_DIR + File.separator + "src/main/java/config/AppConfig.properties";
	String LOG4J_PATH = USER_DIR + File.separator + "src/main/java/config/Log4j.properties";
	String TEST_DATA_PATH = USER_DIR + File.separator + "testdata";

	/** APP CONFIG DATA **/

	Integer FORIEGN_PLAYER = Integer
			.valueOf(FileOperations.getConfigValue(APP_CONFIG_PATH, AppConfigKey.FOREIGN_PLAYER_COUNT));
	Integer WIKCET_KEEPER = Integer
			.valueOf(FileOperations.getConfigValue(APP_CONFIG_PATH, AppConfigKey.WICKET_KEEPER_COUNT));
	String JSON_FILE = TEST_DATA_PATH + File.separator
			+ FileOperations.getConfigValue(APP_CONFIG_PATH, AppConfigKey.JSON_FILE_NAME);

}
