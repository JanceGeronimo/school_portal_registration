import java.util.regex.*;

public class RegularExpression {


    public RegularExpression(String regex, String word){

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(word);
        boolean match = matcher.find();

        if(!match){
            System.exit(0);
        }
    }

}
