package com.school.comp.AddressParser;

import org.parboiled.Parboiled;
import org.parboiled.parserunners.RecoveringParseRunner;
import org.parboiled.common.StringUtils;
import static org.parboiled.support.ParseTreeUtils.printNodeTree;
import org.parboiled.support.ParsingResult;

import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		AddressParser parser = Parboiled.createParser(AddressParser.class);
		Scanner scnr = new Scanner(System.in);
		
		while(true) {
			// handle multiple lines
			System.out.println("Enter input: ");
			String input = scnr.nextLine();
			input += " " + scnr.nextLine();
			input += " " + scnr.nextLine();
			System.out.println(input);
			
            if (StringUtils.isEmpty(input)) break;
            
            ParsingResult<?> result = new RecoveringParseRunner(parser.Input()).run(input);
            System.out.println(printNodeTree(result) + '\n');
		}
	}
}
