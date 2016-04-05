package org.elasticsearch.awesomeplugin;

import org.elasticsearch.ElasticSearchException;
import org.elasticsearch.common.component.AbstractLifecycleComponent;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.settings.SettingsFilter;

public class AwesomePluginService extends AbstractLifecycleComponent<AwesomePluginService>
{
	@Inject
	public AwesomePluginService(Settings settings, SettingsFilter settingsFilter) {
		super(settings);
	}

	@Override
	protected void doClose() throws ElasticSearchException {
	}

	@Override
	protected void doStart() throws ElasticSearchException {
		// read some settings
		String host = componentSettings.get("host", "localhost");
		int port = componentSettings.getAsInt("port", 12345);
	}

	@Override
	protected void doStop() throws ElasticSearchException {
	}
}
