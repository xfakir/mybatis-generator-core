package org.mybatis.generator;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.internal.DefaultCommentGenerator;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName : MyCommentGenerator
 * @Description :
 * @Author : xfakir
 * @Date : 2019-07-01 18:04
 * @Version : 1.0
 */
public class MyCommentGenerator extends DefaultCommentGenerator {
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        StringBuilder sb = new StringBuilder();
        field.addJavaDocLine("/**");
        field.addJavaDocLine(" * <pre>");
        if (introspectedColumn.getRemarks() != null) {
            field.addJavaDocLine(" * " + introspectedColumn.getRemarks());
        }
        sb.append(" * 表字段: ");
        sb.append(introspectedColumn.getFullyQualifiedJavaType());
        sb.append(".");
        sb.append(introspectedColumn.getActualColumnName());
        field.addJavaDocLine(sb.toString());
        field.addJavaDocLine(" * </pre>");
        field.addJavaDocLine(" *");
        field.addJavaDocLine(" */");
    }

    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {

    }

    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

        StringBuilder sb = new StringBuilder();
        topLevelClass.addJavaDocLine("/**");
        sb.append(" * @ClassName : ");
        sb.append(MybatisUtils.transferTableNameToClassName(introspectedTable.getFullyQualifiedTable().toString()));
        topLevelClass.addJavaDocLine(sb.toString());
        sb = new StringBuilder();
        sb.append(" * @Description : 表名: ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        topLevelClass.addJavaDocLine(sb.toString());
        topLevelClass.addJavaDocLine(" * @Author : xfakir");
        sb = new StringBuilder();
        sb.append(" * @Date :");
        sb.append((new SimpleDateFormat("yyyy-MM-dd hh:mm")).format(new Date()));
        topLevelClass.addJavaDocLine(sb.toString());
        topLevelClass.addJavaDocLine(" * @Version : 1.0");
        topLevelClass.addJavaDocLine(" */");
    }

}
