package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        MethodSignature methodSignature;
        int firstBrace = signatureString.indexOf('(');
        int secondBrace = signatureString.indexOf(')');
        String [] beforeBrace = signatureString.substring(0, firstBrace).split(" ");
        String [] parameters = signatureString.substring(firstBrace + 1, secondBrace).split(", ");
        List<MethodSignature.Argument> argumentList = new ArrayList< >();
        if(secondBrace - firstBrace != 1){
            for (String arg : parameters) {
                String type = arg.substring(0, arg.indexOf(' '));
                String name = arg.substring(arg.indexOf(' ') + 1);
                argumentList.add(new MethodSignature.Argument(type, name));
            }
        }
        if (beforeBrace.length == 3){
            methodSignature = new MethodSignature(beforeBrace[2], argumentList);
            methodSignature.setAccessModifier(beforeBrace[0]);
            methodSignature.setReturnType(beforeBrace[1]);
        } else {
            methodSignature = new MethodSignature(beforeBrace[1], argumentList);
            methodSignature.setReturnType(beforeBrace[0]);
        }
        return methodSignature;
    }
}
