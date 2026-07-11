package retry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{ //predefined interface to implement retry

	private static final Logger LOG = (Logger) LogManager.getLogger("Retry.class");//predefind class
	private static final int maxTry = 2; //variable to apply max no of retry count
	private int count = 0; //track the no of retry

	@Override
	public boolean retry(final ITestResult iTestResult) {
	if (!iTestResult.isSuccess()) {
	if (this.count < maxTry) {
	LOG.info("Retrying test " + iTestResult.getName() + " with status "
	+ getResultStatusName(iTestResult.getStatus()) + " for the " + (this.count + 1) + " time(s).");
	this.count++;
	return true;
	}
	}
	return false;
	}

	public String getResultStatusName(final int status) {
	String resultName = null;
	if (status == 1) {
	resultName = "SUCCESS";
	}
	if (status == 2) {
	resultName = "FAILURE";
	}
	if (status == 3) {
	resultName = "SKIP";
	}
	return resultName;
	}
}
