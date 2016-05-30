package io.github.tryexceptelse.jdex;

/**
 * Settings object to store program settings.
 */
class Settings {
    private String autoSaveLoc;
    private String defaultSaveLoc;
    private String lastSavedFile;

    public String getAutoSaveLoc() {
        return autoSaveLoc;
    }

    public void setAutoSaveLoc(String autoSaveLoc) {
        this.autoSaveLoc = autoSaveLoc;
    }

    public String getDefaultSaveLoc() {
        return defaultSaveLoc;
    }

    public void setDefaultSaveLoc(String defaultSaveLoc) {
        this.defaultSaveLoc = defaultSaveLoc;
    }

    public String getLastSavedFile() {
        return lastSavedFile;
    }

    public void setLastSavedFile(String lastSavedFile) {
        this.lastSavedFile = lastSavedFile;
    }
}
