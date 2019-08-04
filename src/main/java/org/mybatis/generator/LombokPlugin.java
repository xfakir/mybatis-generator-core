package org.mybatis.generator;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName : LombokPlugin
 * @Description :
 * @Author : xfakir
 * @Date : 2019-07-01 20:10
 * @Version : 1.0
 */
public class LombokPlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        //添加domain的import
        topLevelClass.addImportedType("lombok.Getter");
        topLevelClass.addImportedType("lombok.Setter");
        topLevelClass.addImportedType("lombok.ToString");

        //添加domain的注解
        topLevelClass.addAnnotation("@Getter");
        topLevelClass.addAnnotation("@Setter");
        topLevelClass.addAnnotation("@ToString");

        return true;
    }

    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        //import
        interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Mapper"));


        //Mapper文件的注释
        StringBuilder sb = new StringBuilder();
        interfaze.addJavaDocLine("/**");
        sb.append(" * @ClassName : ");
        sb.append(MybatisUtils.transferTableNameToClassName(introspectedTable.getFullyQualifiedTable().toString()));
        interfaze.addJavaDocLine(sb.toString());
        sb = new StringBuilder();
        sb.append(" * @Description : 表名: ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        interfaze.addJavaDocLine(sb.toString());
        interfaze.addJavaDocLine(" * @Author : xfakir");
        sb = new StringBuilder();
        sb.append(" * @Date :");
        sb.append((new SimpleDateFormat("yyyy-MM-dd hh:mm")).format(new Date()));
        interfaze.addJavaDocLine(sb.toString());
        interfaze.addJavaDocLine(" * @Version : 1.0");
        interfaze.addJavaDocLine(" *");
        interfaze.addJavaDocLine(" */");

        //注解
        interfaze.addAnnotation("@Mapper");
        return true;
    }

    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        //不生成getter
        return false;
    }

    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        //不生成setter
        return false;
    }

}
