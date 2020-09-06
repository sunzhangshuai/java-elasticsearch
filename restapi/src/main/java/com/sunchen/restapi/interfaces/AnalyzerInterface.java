package com.sunchen.restapi.interfaces;

/**
 * AnalyzerInterface:
 *
 * @author sunchen
 * @date 2020/9/6 12:18 下午
 */
public interface AnalyzerInterface {
    /**
     * 直接指定分词器进行分词测试
     *
     * @param   analyzer
     * @param   text
     *
     * @return array
     */
    String testByAnalyzer(String analyzer, String text);

    /**
     * 直接指定索引的字段进行分词测试
     *
     * @param   index
     * @param   field
     * @param   text
     *
     * @return array
     */
    String testByField(String index, String field, String text);

    /**
     * 自定义索引字段进行测试
     *
     * @param   tokenizer 分词规则
     * @param charFilter
     * @param   filter    分开的词语加工规则1
     * @param   text
     *
     * @return array
     */
    String testByCustom(String tokenizer, String[] charFilter, String[] filter, String text);

    /**
     * 标准分词器
     *
     * @param  text
     *
     * @return array
     */
    String  standardAnalyzer(String text);

    /**
     * 简单分词器
     *
     * @param  text
     *
     * @return array
     */
    String  simpleAnalyzer(String text);

    /**
     * 空格分词器
     *
     * @param  text
     *
     * @return array
     */
    String  whitespaceAnalyzer(String text);

    /**
     * 停用词分词器 （the in a）
     *
     * @param  text
     *
     * @return
     */
    String  stopAnalyzer(String text);

    /**
     * 整体分词器
     *
     * @param  text
     *
     * @return
     */
    String  keywordAnalyzer(String text);

    /**
     * 正则分词器
     *
     * @param  text
     *
     * @return
     */
    String  patternAnalyzer(String text);

    /**
     * 英文分词器  负数、时态
     *
     * @param  text
     *
     * @return 
     */
    String  englishAnalyzer(String text);

    /**
     * 简单的中文分词器
     * 插件安装办法
     * elasticsearch_9500/bin/elasticsearch-plugin  install analysis-icu
     *
     * @param  text
     *
     * @return
     */
    String icuanalyzer(String text);

    /**
     * 较好的中文分词器
     * 插件安装办法
     * elasticsearch-plugin  install https://github.com/medcl/elasticsearch-analysis-ik/releases/download/v7.8.1/elasticsearch-analysis-ik-7.8.1.zip
     *
     * @param  text
     *
     * @return
     */
    String ikanalyzer(String text);

    /**
     * 在索引中定义新的分词器
     *
     * @return string
     */

    String mappingDefinitionAnalyzer();
}
