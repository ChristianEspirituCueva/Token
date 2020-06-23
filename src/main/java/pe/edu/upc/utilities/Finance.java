package pe.edu.upc.utilities;


public final class Finance{

    private static final double LOW_RATE = 0.01;
    private static final double HIGH_RATE = 0.5;
    private static final double MAX_ITERATION = 1000;
    private static final double PRECISION_REQ = 0.00000001;

    public static double computeIRR(double cf[], int numOfFlows){
        int i = 0,j = 0;
        double m = 0.0;
        double old = 0.00;
        double last = 0.00;
        double oldguessRate = LOW_RATE;
        double newguessRate = LOW_RATE;
        double guessRate = LOW_RATE;
        double lowGuessRate = LOW_RATE;
        double highGuessRate = HIGH_RATE;
        double npv = 0.0;
        double denom = 0.0;
        for(i=0; i<MAX_ITERATION; i++){
            npv = 0.00;
            for(j=0; j<numOfFlows; j++){
                denom = Math.pow((1 + guessRate),j);
                npv = npv + (cf[j]/denom);
            }
            /* Stop checking once the required precision is achieved */
            if((npv > 0) && (npv < PRECISION_REQ))
            break;
            if(old == 0)
            old = npv;
            else
            old = last;
            last = npv;
            if(i > 0){
                if(old < last){
                    if(old < 0 && last < 0)
                    highGuessRate = newguessRate;
                    else
                    lowGuessRate = newguessRate;
                }
                else{
                    if(old > 0 && last > 0)
                    lowGuessRate = newguessRate;
                    else
                    highGuessRate = newguessRate;
                }
            }
            oldguessRate = guessRate;
            guessRate = (lowGuessRate + highGuessRate) / 2;
            newguessRate = guessRate;
        }
        return guessRate;
    }
}


