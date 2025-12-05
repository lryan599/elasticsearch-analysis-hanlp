package com.hankcs.cfg;

import com.hankcs.dic.Dictionary;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;

/**
 * Project: elasticsearch-analysis-hanlp
 * Description: 配置信息
 * Author: Kenn
 * Create: 2018-12-14 15:10
 * Adapt for Elasticsearch 8.19: 移除 Guice @Inject 注解，优化配置读取逻辑
 */
public class Configuration {

    private final Environment environment;
    private final Settings settings;

    // 配置项（保持原有语义）
    private boolean enablePorterStemming;
    private boolean enableIndexMode;
    private boolean enableNumberQuantifierRecognize;
    private boolean enableCustomDictionary;
    private boolean enableTranslatedNameRecognize;
    private boolean enableJapaneseNameRecognize;
    private boolean enableOrganizationRecognize;
    private boolean enablePlaceRecognize;
    private boolean enableNameRecognize;
    private boolean enableTraditionalChineseMode;
    private boolean enableStopDictionary;
    private boolean enablePartOfSpeechTagging;
    private boolean enableRemoteDict;
    private boolean enableNormalization;
    private boolean enableOffset;
    private boolean enableCustomConfig;

    /**
     * 移除 @Inject 注解，改为显式构造器（由 Plugin 手动传入依赖）
     * @param environment Elasticsearch 环境上下文（8.x 由 Plugin.createComponents 提供）
     * @param settings 配置项（8.x 支持更安全的 getAsBoolean 方法）
     */
    public Configuration(Environment environment, Settings settings) {
        this.environment = environment;
        this.settings = settings;

        // 优化：使用 8.x 推荐的 getAsBoolean 方法（避免字符串比较，更安全）
        this.enablePorterStemming = settings.getAsBoolean("enable_porter_stemming", false);
        this.enableIndexMode = settings.getAsBoolean("enable_index_mode", false);
        this.enableNumberQuantifierRecognize = settings.getAsBoolean("enable_number_quantifier_recognize", false);
        this.enableCustomDictionary = settings.getAsBoolean("enable_custom_dictionary", true);
        this.enableTranslatedNameRecognize = settings.getAsBoolean("enable_translated_name_recognize", true);
        this.enableJapaneseNameRecognize = settings.getAsBoolean("enable_japanese_name_recognize", false);
        this.enableOrganizationRecognize = settings.getAsBoolean("enable_organization_recognize", false);
        this.enablePlaceRecognize = settings.getAsBoolean("enable_place_recognize", false);
        this.enableNameRecognize = settings.getAsBoolean("enable_name_recognize", true);
        this.enableTraditionalChineseMode = settings.getAsBoolean("enable_traditional_chinese_mode", false);
        this.enableStopDictionary = settings.getAsBoolean("enable_stop_dictionary", false);
        this.enablePartOfSpeechTagging = settings.getAsBoolean("enable_part_of_speech_tagging", false);
        this.enableRemoteDict = settings.getAsBoolean("enable_remote_dict", true);
        this.enableNormalization = settings.getAsBoolean("enable_normalization", false);
        this.enableOffset = settings.getAsBoolean("enable_offset", true);
        this.enableCustomConfig = settings.getAsBoolean("enable_custom_config", false);

        Dictionary.initial(this);
    }

    // 以下 getter/setter 方法保持不变（保证原有业务逻辑兼容性）
    public Environment getEnvironment() {
        return this.environment;
    }

    public Settings getSettings() {
        return this.settings;
    }

    public boolean isEnablePorterStemming() {
        return this.enablePorterStemming;
    }

    public Configuration enablePorterStemming(boolean enablePorterStemming) {
        this.enablePorterStemming = enablePorterStemming;
        return this;
    }

    public boolean isEnableIndexMode() {
        return this.enableIndexMode;
    }

    public Configuration enableIndexMode(boolean enableIndexMode) {
        this.enableIndexMode = enableIndexMode;
        return this;
    }

    public boolean isEnableNumberQuantifierRecognize() {
        return this.enableNumberQuantifierRecognize;
    }

    public Configuration enableNumberQuantifierRecognize(boolean enableNumberQuantifierRecognize) {
        this.enableNumberQuantifierRecognize = enableNumberQuantifierRecognize;
        return this;
    }

    public boolean isEnableCustomDictionary() {
        return this.enableCustomDictionary;
    }

    public Configuration enableCustomDictionary(boolean enableCustomDictionary) {
        this.enableCustomDictionary = enableCustomDictionary;
        return this;
    }

    public boolean isEnableTranslatedNameRecognize() {
        return this.enableTranslatedNameRecognize;
    }

    public Configuration enableTranslatedNameRecognize(boolean enableTranslatedNameRecognize) {
        this.enableTranslatedNameRecognize = enableTranslatedNameRecognize;
        return this;
    }

    public boolean isEnableJapaneseNameRecognize() {
        return this.enableJapaneseNameRecognize;
    }

    public Configuration enableJapaneseNameRecognize(boolean enableJapaneseNameRecognize) {
        this.enableJapaneseNameRecognize = enableJapaneseNameRecognize;
        return this;
    }

    public boolean isEnableOrganizationRecognize() {
        return this.enableOrganizationRecognize;
    }

    public Configuration enableOrganizationRecognize(boolean enableOrganizationRecognize) {
        this.enableOrganizationRecognize = enableOrganizationRecognize;
        return this;
    }

    public boolean isEnablePlaceRecognize() {
        return this.enablePlaceRecognize;
    }

    public Configuration enablePlaceRecognize(boolean enablePlaceRecognize) {
        this.enablePlaceRecognize = enablePlaceRecognize;
        return this;
    }

    public boolean isEnableNameRecognize() {
        return this.enableNameRecognize;
    }

    public Configuration enableNameRecognize(boolean enableNameRecognize) {
        this.enableNameRecognize = enableNameRecognize;
        return this;
    }

    public boolean isEnableTraditionalChineseMode() {
        return this.enableTraditionalChineseMode;
    }

    public Configuration enableTraditionalChineseMode(boolean enableTraditionalChineseMode) {
        this.enableTraditionalChineseMode = enableTraditionalChineseMode;
        return this;
    }

    public boolean isEnableStopDictionary() {
        return this.enableStopDictionary;
    }

    public Configuration enableStopDictionary(boolean enableStopDictionary) {
        this.enableStopDictionary = enableStopDictionary;
        return this;
    }

    public boolean isEnablePartOfSpeechTagging() {
        return this.enablePartOfSpeechTagging;
    }

    public Configuration enablePartOfSpeechTagging(boolean enablePartOfSpeechTagging) {
        this.enablePartOfSpeechTagging = enablePartOfSpeechTagging;
        return this;
    }

    public boolean isEnableRemoteDict() {
        return enableRemoteDict;
    }

    public Configuration enableRemoteDict(boolean enableRemoteDict) {
        this.enableRemoteDict = enableRemoteDict;
        return this;
    }

    public boolean isEnableNormalization() {
        return enableNormalization;
    }

    public Configuration enableNormalization(boolean enableNormalization) {
        this.enableNormalization = enableNormalization;
        return this;
    }

    public boolean isEnableOffset() {
        return enableOffset;
    }

    public Configuration enableOffset(boolean enableOffset) {
        this.enableOffset = enableOffset;
        return this;
    }

    public boolean isEnableCustomConfig() {
        return enableCustomConfig;
    }

    public Configuration enableCustomConfig(boolean enableCustomConfig) {
        this.enableCustomConfig = enableCustomConfig;
        return this;
    }
}