<h1 align="center">Seekers Plugin Template</h1>

You want to easily create a new plugin for seekers? This is your starting point!

## Extensions

All plugins have an extension that implements the function from the `SeekersExtension` and must be marked with
`@Extension`. The function `setup` is always called first. Every plugin has its own config group in the `config.ini`
file of the server. The group is named after the plugin id. For this plugin `seekers-plugin-template`, this may look
like this:

```ini
[seekers-plugin-template]
key1 = value1
key2 = value2
```

## Distribution

Please note that plugins must be distributed as an uber jar, with all dependencies that the server not already have.
Therefore, the gradle task `plugin` was added in this template, but you may want to modify it.