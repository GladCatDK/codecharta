package de.maibornwolff.codecharta.importer.sourcecodeparser.oop.infrastructure.antlr.java;

import de.maibornwolff.codecharta.importer.sourcecodeparser.oop.core.antlrinterop.CodeTags;
import de.maibornwolff.codecharta.importer.sourcecodeparser.oop.core.antlrinterop.Source;

public class ExtendedBaseVisitor extends JavaParserBaseVisitor {

    private Source source;

    public ExtendedBaseVisitor(Source source){
        this.source = source;
    }

    @Override
    public Object visitPackageDeclaration(JavaParser.PackageDeclarationContext ctx) {
        source.addTag(ctx.getStart().getLine(), CodeTags.PACKAGE);
        return visitChildren(ctx);
    }

    @Override
    public Object visitImportDeclaration(JavaParser.ImportDeclarationContext ctx) {
        source.addTag(ctx.getStart().getLine(), CodeTags.IMPORT);
        return visitChildren(ctx);
    }

    @Override
    public Object visitAnnotation(JavaParser.AnnotationContext ctx) {
        source.addTag(ctx.getStart().getLine(), CodeTags.ANNOTATION_INVOCATION);
        return visitChildren(ctx);
    }

    /**
     * --> @interface BlockingOperations {
     *          boolean fileSystemOperations();
     *     }
     */
    @Override
    public Object visitAnnotationTypeDeclaration(JavaParser.AnnotationTypeDeclarationContext ctx) {
        source.addTag(ctx.getStart().getLine(), CodeTags.ANNOTATION);
        return visitChildren(ctx);
    }

    /**
     *     @interface BlockingOperations {
     * -->      boolean fileSystemOperations();
     * -->      boolean networkOperations() default false;
     *     }
     */
    @Override
    public Object visitAnnotationTypeElementDeclaration(JavaParser.AnnotationTypeElementDeclarationContext ctx) {
        source.addTag(ctx.getStart().getLine(), CodeTags.ANNOTATION_ELEMENT);
        return visitChildren(ctx);
    }

    @Override
    public Object visitClassDeclaration(JavaParser.ClassDeclarationContext ctx) {
        source.addTag(ctx.getStart().getLine(), CodeTags.CLASS);
        return visitChildren(ctx);
    }

    @Override
    public Object visitInterfaceDeclaration(JavaParser.InterfaceDeclarationContext ctx) {
        source.addTag(ctx.getStart().getLine(), CodeTags.INTERFACE);
        return visitChildren(ctx);
    }

    @Override
    public Object visitEnumDeclaration(JavaParser.EnumDeclarationContext ctx) {
        source.addTag(ctx.getStart().getLine(), CodeTags.ENUM);
        return visitChildren(ctx);
    }

    @Override
    public Object visitConstructorDeclaration(JavaParser.ConstructorDeclarationContext ctx) {
        source.addTag(ctx.getStart().getLine(), CodeTags.CONSTRUCTOR);
        return visitChildren(ctx);
    }

    /** Called when a constant in an interface is found **/
    @Override
    public Object visitConstDeclaration(JavaParser.ConstDeclarationContext ctx) {
        source.addTag(ctx.getStart().getLine(), CodeTags.INTERFACE_CONSTANT);
        return visitChildren(ctx);
    }

    @Override
    public Object visitFieldDeclaration(JavaParser.FieldDeclarationContext ctx) {
        source.addTag(ctx.getStart().getLine(), CodeTags.CLASS_FIELD);
        return visitChildren(ctx);
    }

    @Override
    public Object visitInterfaceMethodDeclaration(JavaParser.InterfaceMethodDeclarationContext ctx) {
        source.addTag(ctx.getStart().getLine(), CodeTags.METHOD);
        return visitChildren(ctx);
    }

    @Override
    public Object visitMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
        source.addTag(ctx.getStart().getLine(), CodeTags.METHOD);
        return visitChildren(ctx);
    }

    @Override
    public Object visitVariableDeclarator(JavaParser.VariableDeclaratorContext ctx) {
        source.addTag(ctx.getStart().getLine(), CodeTags.VARIABLE);
        return visitChildren(ctx);
    }

    @Override
    public Object visitStatement(JavaParser.StatementContext ctx) {
        source.addTag(ctx.getStart().getLine(), CodeTags.STATEMENT);
        if(ctx.IF() != null) { source.addTag(ctx.getStart().getLine(), CodeTags.CONDITION);}
        if(ctx.ELSE() != null) { source.addTag(ctx.getStart().getLine(), CodeTags.CONDITION);}
        return visitChildren(ctx);
    }

    @Override
    public Object visitEnumConstant(JavaParser.EnumConstantContext ctx) {
        source.addTag(ctx.getStart().getLine(), CodeTags.ENUM_CONSTANT);
        return visitChildren(ctx);
    }

    @Override
    public Object visitExpression(JavaParser.ExpressionContext ctx) {
        source.addTag(ctx.getStart().getLine(), CodeTags.EXPRESSION);
        return visitChildren(ctx);
    }

    @Override
    public Object visitMethodCall(JavaParser.MethodCallContext ctx) {
        source.addTag(ctx.getStart().getLine(), CodeTags.METHOD_CALL);
        return visitChildren(ctx);
    }

}
