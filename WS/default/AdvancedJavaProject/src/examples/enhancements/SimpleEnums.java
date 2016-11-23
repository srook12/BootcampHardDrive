package examples.enhancements;

public class SimpleEnums{
    enum MonthEnum {JANUARY, FEBRUARY, MARCH,
        APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER,
        OCTOBER, NOVEMBER, DECEMBER}

    enum SeasonEnum {SPRING, SUMMER, FALL, WINTER}
    
    public static void main(String args[]){
        MonthEnum m = MonthEnum.JANUARY;
        SeasonEnum s = getSeason(m);
        System.out.println(m + " is in the " + s);
    }
    private static SeasonEnum getSeason(MonthEnum m){
        switch(m){
            case MARCH:
            case APRIL:
            case MAY:
        	return SeasonEnum.SPRING;
            case JUNE:
            case JULY:
            case AUGUST:
        	return SeasonEnum.SUMMER;
            case SEPTEMBER:
            case OCTOBER:
            case NOVEMBER:
        	return SeasonEnum.FALL;
            case DECEMBER:
            case JANUARY:
            case FEBRUARY:
        	return SeasonEnum.WINTER;
            default:
        	return null;
        }
    }
}