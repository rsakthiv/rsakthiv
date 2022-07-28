package rcb;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.AfterClass;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import constants.AppConfigData;
import utils.JSONReader;

public class TeamRCBTests {
	Logger log;

	@BeforeClass
	public void startUp() {
		log = Logger.getLogger(TeamRCBTests.class);
		PropertyConfigurator.configure(AppConfigData.LOG4J_PATH);
		log.info("**** Test Execution Started ****");
	}

	@Test
	public void verifyRCBTeamHasOnlyFourForiegnPlayers() {
		log.info("verifyRCBTeamHasOnlyFourForiegnPlayers() test started");
		Integer actualForiegnPlayerCount = JSONReader.getNestedJSONDataCount(AppConfigData.JSON_FILE, "player", "country",
				"India", false);
		Assert.assertEquals(actualForiegnPlayerCount, AppConfigData.FORIEGN_PLAYER);
		log.info("verifyRCBTeamHasOnlyFourForiegnPlayers() test completed");
	}

	@Test
	public void verifyRCBTeamHasWicketKeeper() {
		log.info("verifyRCBTeamHasWicketKeeper() test started");
		Integer actualWicketKeeperCount = JSONReader.getNestedJSONDataCount(AppConfigData.JSON_FILE, "player", "role",
				"Wicket-keeper", true);
		Assert.assertEquals(actualWicketKeeperCount, AppConfigData.WIKCET_KEEPER);
		log.info("verifyRCBTeamHasWicketKeeper() test completed");
	}

	@AfterClass
	public void tearDown() {
		log.info("**** Test Execution Completed ****");
	}

}
