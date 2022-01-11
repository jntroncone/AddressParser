package com.school.comp.AddressParser;

import org.parboiled.BaseParser;
import org.parboiled.Rule;
import org.parboiled.annotations.BuildParseTree;


@BuildParseTree
public class AddressParser extends BaseParser<Object>{
	// defined punctuation
	public static String comma = ", ";
	public static char space = ' ';
	public static char period = '.';
	public static char lp = '(';
	public static char rp = ')';
	public static char hyphen = '-';
	// rules
	public Rule Input() {
		return Sequence(Name(), space, Address(), space, PhoneNumber());
	}
	
	public Rule Name() {
		return Sequence(FirstName(), space, Optional(MiddleInitial(), period, space), LastName());
	}
	
	public Rule FirstName() {
		return Sequence(Uppercase(), OneOrMore(Lowercase()));
	}
	
	public Rule MiddleInitial() {
		return Uppercase();
	}
	
	public Rule LastName() {
		return Sequence(Uppercase(), OneOrMore(Lowercase()));
	}
	
	public Rule Address() {
		return Sequence(StreetNum(), space, StreetName(), comma, City(), comma, State(), comma, Country());
	}
	
	public Rule StreetNum() {
		return OneOrMore(Digit());
	}
	
	public Rule StreetName() {
		return Sequence(OneOrMore(Letter()), space, OneOrMore(Letter()));
	}

	public Rule City() {
		return Sequence(Uppercase(), OneOrMore(Letter()));
	}
	
	public Rule State() {
		return Sequence(Uppercase(), OneOrMore(Letter()));
	}
	
	public Rule Country() {
		return Sequence(Uppercase(), OneOrMore(Letter()));
	}
	
	public Rule PhoneNumber() {
		return Sequence(lp, Digit(), Digit(), Digit(), rp, space, Digit(), Digit(), Digit(), hyphen, Digit(), Digit(), Digit(), Digit());
	}
	
	public Rule Letter() {
		return FirstOf(Uppercase(), Lowercase()); 
	}
	
	public Rule Uppercase() {
		return CharRange('A', 'Z');
	}
	
	public Rule Lowercase() {
		return CharRange('a', 'z');
	}
	
	public Rule Digit() {
		return CharRange('0', '9');
	}
}
