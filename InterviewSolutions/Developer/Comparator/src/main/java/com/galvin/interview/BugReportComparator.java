package com.galvin.interview;

import java.util.Comparator;

/**
 * This class sorts Bug Reports by severity, then urgency.
 * 
 * Bugs should be sorted according to severity first; e.g. all
 * World-ending bugs come first, then all Large bugs, then all Medium bugs,
 * then all Low bugs, then all bugs without a severity assigned.
 * 
 * Once the bugs have been sorted by severity, they should be sorted by urgency.
 * All Fix-immediately bugs should come first, followed by all Must-haves,
 * followed by all Should-haves, followed by all Nice-to-haves, followed by
 * any bugs that do not have an urgency associated with them.
 */
public class BugReportComparator implements Comparator<BugReport>
{

    @Override
    public int compare( BugReport bugOne, BugReport bugTwo ) {
        if( bugOne == null && bugTwo != null ){
            return 1;
        } 
        else if( bugOne != null && bugTwo == null ){
            return -1;
        }
        else if( bugOne == null && bugTwo == null ){
            return 0;
        }
        
        Severity severityOne = bugOne.getSeverity();
        Severity severityTwo = bugTwo.getSeverity();
        int severityComparison = compare( severityOne, severityTwo );
        if( severityComparison != 0 ){
            return severityComparison;
        }
        
        Urgency urgencyOne = bugOne.getUrgency();
        Urgency urgencyTwo = bugTwo.getUrgency();
        return compare( urgencyOne, urgencyTwo );
    }
    
    private int compare( Severity severityOne, Severity severityTwo ) {
        if( severityOne == null && severityTwo != null ){
            return 1;
        } 
        else if( severityOne != null && severityTwo == null ){
            return -1;
        }
        else if( severityOne == null && severityTwo == null ){
            return 0;
        }
        
        // higher severities have higher ordinals, but should come first in the
        // list. Because of that, we actually want the *opposite* of a natural
        // comparison.
        return -1 * ( severityOne.ordinal() - severityTwo.ordinal() );
    }
    
    private int compare( Urgency urgencyOne, Urgency urgencyTwo ) {
        if( urgencyOne == null && urgencyTwo != null ){
            return 1;
        } 
        else if( urgencyOne != null && urgencyTwo == null ){
            return -1;
        }
        else if( urgencyOne == null && urgencyTwo == null ){
            return 0;
        }
        
        // higher urgencies have higher ordinals, but should come first in the
        // list. Because of that, we actually want the *opposite* of a natural
        // comparison.
        return -1 * ( urgencyOne.ordinal() - urgencyTwo.ordinal() );
    }
}
