package Jira;

import Utils.Log;
import com.google.common.collect.ImmutableMap;
import net.rcarz.jiraclient.*;
import net.rcarz.jiraclient.Issue.FluentCreate;

import static Jira.Constants.REPORTER;

public class JiraServiceProvider {

	public JiraClient jira;
	public String project;

	public JiraServiceProvider(String jiraUrl, String username, String password, String project) {
		BasicCredentials creds = new BasicCredentials(username, password);
		jira = new JiraClient(jiraUrl, creds);
		this.project = project;
	}

	public void createJiraTicket(String issueType, String summary, String description, String reporterName) {

		try {
			FluentCreate fleuntCreate = jira.createIssue(project, issueType);
			fleuntCreate.field(Field.SUMMARY, summary);
			fleuntCreate.field(Field.DESCRIPTION, description);
			fleuntCreate.field(Field.REPORTER, reporterName);
			Issue newIssue = fleuntCreate.execute();

			Log.info("new issue created in JIRA with ID: " + newIssue);

		} catch (JiraException e) {
			e.printStackTrace();
		}

	}

}
