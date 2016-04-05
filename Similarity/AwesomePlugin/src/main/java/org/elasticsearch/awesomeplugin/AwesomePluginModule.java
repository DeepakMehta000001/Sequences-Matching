package org.elasticsearch.awesomeplugin;

import org.elasticsearch.common.inject.AbstractModule;
import org.elasticsearch.common.settings.Settings;

public class AwesomePluginModule extends AbstractModule {
	private final Settings settings;

	public AwesomePluginModule(Settings settings) {
		this.settings = settings;
	}

	@Override
	protected void configure() {
		bind(AwesomePluginService.class).asEagerSingleton();
	}
}