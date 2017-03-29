/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import CONNECTION.DB_Connection;
import MODEL.MOD_KTP_Data;
import MODEL.MOD_Key;
import MODEL.MOD_Override_QR_Data;
import MODEL.MOD_RandomNumberGenerator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Long
 */
public class DAO_RandomNumberGenerator {
    
    // global counter
    public String[] occupiedCoordinate = new String[30];
    public int[] occupiedValue = new int[30];
    public int[] occupiedCoordinateX = new int[30];
    public int[] occupiedCoordinateY = new int[30];
    private int globalCoordinateCounter = 0;
    private int globalCoordinateCounterStop = 0;
    
    public List<MOD_RandomNumberGenerator> RandomGenerator(int x, int y){
    List<MOD_RandomNumberGenerator> MRNG = new ArrayList<MOD_RandomNumberGenerator>();
        MOD_RandomNumberGenerator modRGN = new MOD_RandomNumberGenerator();
        
        Random r = new Random();
        int[][] arrayNumber = new int[y][x];

        for(int ix = 0; ix < arrayNumber.length; ix++){
            for(int i = 0; i < x; i++) {
                arrayNumber[ix][i] = r.nextInt(10);
//                System.out.print(arrayNumber[ix][i] + "  ");
            }
//            System.out.println("");
        }
        
        modRGN.setRandomNumber(arrayNumber);
        MRNG.add(modRGN);
        return MRNG;
    }
    
    public int[] UniqueNumberConverter(int input){
        String result = "";
        Random randGen = new Random();
        int randomNumber = 0;
        boolean randomCheck = false;
        int[] numberGen = new int[5]; // how many number?
        
        String DEBUG_RANDOM = "";
        try {
            randomNumber = randGen.nextInt(5);
            HashSet<Integer> set = new HashSet<Integer>();

            for(int i = 0; i < 5; i++){
                boolean containCheck = set.contains(randomNumber);
                while(randomCheck == false){
                    randomNumber = randGen.nextInt(9)+1; // min 2, max 9
                    if(set.contains(randomNumber) == false){
                        set.add(randomNumber);
                        randomCheck = true;
                    } else {
                        randomCheck = false;
                    }
                }
                randomCheck = false;
            }

            // begin sum all number && insert into array
            int ixa = 0;
            int compare = 0;
            
            for (Integer value : set) {
                compare += value;
                numberGen[ixa] = value;
                ixa++;
            }

            // compare input dan hasil value
            if(compare == input){
    //            System.out.println("SAMA = "+input+" compare = "+compare+"\n");
                generateRandomKEY(numberGen); // call generator coordinate
            } else {
                UniqueNumberConverter(input);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada konversi numerik", "Konversi Error", JOptionPane.ERROR_MESSAGE);
        }
        return numberGen;
    }
    
    public String generateRandomKEY(int[] numberConverter){
        String result = "";
        Random randGen = new Random();
        int randomX = 0;
        int[] arrayRandomX = new int[5];
        int randomY = 0;
        int[] arrayRandomY = new int[5];
        boolean randomCheckX = false;
        boolean randomCheckY = false;
        String DEBUG_RANDOMX = "";
        String DEBUG_RANDOMY = "";
        
        // BEGIN generate random X
        randomX = randGen.nextInt(8)+1;
        HashSet<Integer> setHashRandomX = new HashSet<Integer>();
        
        for(int i = 0; i < arrayRandomX.length; i++){
            
            boolean containCheck = setHashRandomX.contains(randomX);
            while(randomCheckX == false){
                randomX = randGen.nextInt(8)+1; // min 2, max 9
                DEBUG_RANDOMX += "-"+randomX;
                if(setHashRandomX.contains(randomX) == false){
                    setHashRandomX.add(randomX);
                    arrayRandomX[i] = randomX;
                    randomCheckX = true;
                } else {
                    randomCheckX = false;
                }
            }
            randomCheckX = false;
        }
        
        // BEGIN generate random Y
        randomY = randGen.nextInt(8)+1;
        
        HashSet<Integer> setHashRandomY = new HashSet<Integer>();
        
        for(int i = 0; i < arrayRandomX.length; i++){
            
            boolean containCheck = setHashRandomY.contains(randomY);
            while(randomCheckY == false){
                randomY = randGen.nextInt(8)+1; // min 2, max 9
                DEBUG_RANDOMY += "-"+randomY;
                if(setHashRandomY.contains(randomY) == false){
                    setHashRandomY.add(randomY);
                    arrayRandomY[i] = randomY;
                    randomCheckY = true;
                } else {
                    randomCheckY = false;
                }
            }
            randomCheckY = false;
        }
        
        boolean CoordinateChecker = false;
        System.out.println("\nKOORDINAT : ");
        innerLoop :
        for(int xx = 0; xx < arrayRandomX.length; xx++){
//            System.out.println("Koordinat #"+xx+" = ("+arrayRandomX[xx]+","+arrayRandomY[xx]+") -> Update Value : "+numberConverter[xx]);
            String CompareCoordinate = arrayRandomX[xx]+","+arrayRandomY[xx];
            for(int ixx = 0; ixx < occupiedCoordinate.length; ixx++){
                if(CompareCoordinate.equals(occupiedCoordinate[ixx])){
                    CoordinateChecker = false;
//                    System.out.println(" ada yang SAMA");
                    globalCoordinateCounter = 5;
                    generateRandomKEY(numberConverter);
                    break innerLoop;
                } else {
                    CoordinateChecker = true;
                }
            }
            if(CoordinateChecker == true){
                occupiedCoordinate[globalCoordinateCounter] = arrayRandomX[xx]+","+arrayRandomY[xx];
                occupiedValue[globalCoordinateCounter] = numberConverter[xx];
                occupiedCoordinateX[globalCoordinateCounter] = arrayRandomX[xx];
                occupiedCoordinateY[globalCoordinateCounter] = arrayRandomY[xx];
                globalCoordinateCounter++;
            }
        }
        
        return result;
    }
    
    public void inputKTPNumbering(String noKTP){
        String[] explodeKTPNumber = noKTP.split("",0);
        int[] arrayKTP = new int[16];
        int i = 0;
        for(String s : explodeKTPNumber){
            if(s != null && s.length() > 0){
                arrayKTP[i] = Integer.parseInt(s);
                i++;
            }
        }
        //injectRandomKEYKTP16(arrayKTP);
    }
    
//    public String injectRandomKEYKTP16(int[] KTPNumber){
//        String result = "";
//        Random randGen = new Random();
//        int randomX = 0;
//        int[] arrayRandomX = new int[16];
//        int randomY = 0;
//        int[] arrayRandomY = new int[16];
//        boolean randomCheckX = false;
//        boolean randomCheckY = false;
//        
//        // BEGIN generate random X KTP 16
//        randomX = randGen.nextInt(8);
//        HashSet<Integer> setHashRandomX = new HashSet<Integer>();
//        
//        for(int i = 0; i < arrayRandomX.length; i++){
//            randomX = randGen.nextInt(8); // min 2, max 9
//            arrayRandomX[i] = randomX;
//        }
//        
//        // BEGIN generate random Y KTP 16
//        randomY = randGen.nextInt(8);
//        HashSet<Integer> setHashRandomY = new HashSet<Integer>();
//        
//        for(int i = 0; i < arrayRandomX.length; i++){
//            randomY = randGen.nextInt(8); // min 2, max 9
//            arrayRandomY[i] = randomY;
//        }
//        
//        boolean CoordinateChecker = false;
//        //System.out.println("\nKOORDINAT KTP : ");
//        innerLoop :
//        for(int xx = 0; xx < arrayRandomX.length; xx++){
//            //System.out.println("Koordinat #"+xx+" = ("+arrayRandomX[xx]+","+arrayRandomY[xx]+") -> Update Value : "+KTPNumber[xx]);
//            String CompareCoordinate = arrayRandomX[xx]+","+arrayRandomY[xx];
//            for(int ixx = 0; ixx < occupiedCoordinate.length; ixx++){
//                if(CompareCoordinate.equals(occupiedCoordinate[ixx])){
//                    CoordinateChecker = false;
//                    //System.out.println(" ada yang SAMA");
//                    globalCoordinateCounter = 10;
//                    //System.out.println("globalCoordinateCounter = "+globalCoordinateCounter);
//                    injectRandomKEYKTP16(KTPNumber);
//                    break innerLoop;
//                } else {
//                    CoordinateChecker = true;
//                }
//            }
//            if(CoordinateChecker == true){
//                occupiedCoordinate[globalCoordinateCounter] = arrayRandomX[xx]+","+arrayRandomY[xx];
//                occupiedValue[globalCoordinateCounter] = KTPNumber[xx];
//                globalCoordinateCounter++;
//            }
//        }
//        
//        return result;
//    }
    
    // begin CORE 4 - 9
    // Generate Maximize Number of Nine
    
    public String generateKeyKTP(int sumNumber){
        int generateRandomize = 0;
        // generate key digit by summarize KTP number automatically
        if(sumNumber < 40){
            generateRandomize = 6;
        } else if(sumNumber >= 40 && sumNumber <= 80){
            generateRandomize = 12;
        } else if (sumNumber > 80){
            generateRandomize = 18;
        }
        
        String result = "";
        Random randGen = new Random();
        int randomNumber = 0;
        int sumRandomNumber = 0;
        int[] valueRandom = new int[generateRandomize];
        int randomX = 0;
        int[] arrayRandomX = new int[generateRandomize];
        int randomY = 0;
        int[] arrayRandomY = new int[generateRandomize];
        boolean randomCheckX = false;
        boolean randomCheckY = false;
        
        String collision = "";
        int positionArray = 10;
        boolean collisionCheckerInput = false;
        for(int ix = 0; ix < generateRandomize; ix++){
            randomX = randGen.nextInt(8)+1;
            randomY = randGen.nextInt(8)+1;
            randomNumber = randGen.nextInt(9)+1;
            
                String compare = randomX+","+randomY;
    //            System.out.println("ix-"+ix+" Generated compare : "+compare+" random Generated : "+randomNumber+" Total : "+sumRandomNumber);

                InnerLoop :
                for(int ixx = 0; ixx < occupiedCoordinate.length; ixx++){
                    if(occupiedCoordinate[ixx] != null){
                        if(occupiedCoordinate[ixx].equals(compare) && occupiedValue[ixx] == randomNumber){
    //                        System.out.println("nilai dan koordinat sama");
                            collision += "NK Sama : "+randomX+","+randomY+" -> "+randomNumber+"\n";
                            collisionCheckerInput = true; // jika koordinat sama dan jika nilainya sama
                            break InnerLoop;
                        } else if(occupiedCoordinate[ixx].equals(compare) && occupiedValue[ixx] != randomNumber){
    //                        System.out.println("koordinat sama tapi nilai berbeda");
                            collision += "NK Beda : "+randomX+","+randomY+" -> nilai asli : "+occupiedValue[ixx]+" random generator : "+randomNumber+"\n";
                            collisionCheckerInput = false; // jika koordinat sama tapi nilai beda = tidak boleh
                            ixx--;
                            break InnerLoop;
                        } else {
                            collisionCheckerInput = true;
                        }
                    } else {

                    }
                }

                //System.out.println(" Collision Check : "+collisionCheckerInput+"\n");
                System.out.println("Collision >\n"+collision+" ");
                if(collisionCheckerInput == true){
                    occupiedCoordinate[positionArray] = randomX+","+randomY;
                    occupiedCoordinateX[positionArray] = randomX;
                    occupiedCoordinateY[positionArray] = randomY;
                    occupiedValue[positionArray] = randomNumber;
                    positionArray++;
                }

                arrayRandomX[ix] = randomX;
                arrayRandomY[ix] = randomY;
                valueRandom[ix] = randomNumber;
            
        }
        
        // BEGIN SUMMATION
        for(int ixa = 10; ixa < occupiedCoordinate.length; ixa++){
            if(occupiedCoordinate[ixa] != null){
                sumRandomNumber += occupiedValue[ixa];
            }
        }
        
        if(sumRandomNumber != sumNumber){
            //System.out.println("\nNOMOR TIDAK SAMA");
            generateKeyKTP(sumNumber);
        } else {
            //System.out.println("DONE");
            for(int ix = 0; ix < valueRandom.length; ix++){
                String results = arrayRandomX[ix]+","+arrayRandomY[ix]+" = "+valueRandom[ix];
                //System.out.println(" RESULT : "+results);
            }
            //System.out.println("Result : Generate : "+sumRandomNumber+" Requested = "+sumNumber);
        }
        
        return result;
    }
    
    // debugging
    public String occupiedCoord(){
        String coordinate = "";
        
        for(int ix = 0; ix < occupiedCoordinate.length; ix++){
            coordinate += "\n "+ix+" - "+occupiedCoordinate[ix]+" - VAL : "+occupiedValue[ix]+" || [ X -> "+occupiedCoordinateX[ix]+" ][ Y -> "+occupiedCoordinateY[ix]+" ]";
        }
        
        return coordinate;
    }
    
    // update value override
    public int[][] UpdateValueData(int[] occupiedX, int[] occupiedY, int[] valueNumber, List<MOD_RandomNumberGenerator> generatedArrayNumber){
        int[][] originalData = null;
        for (MOD_RandomNumberGenerator m : generatedArrayNumber) {
            originalData = m.getRandomNumber();
        }
        
        System.out.println("BEFORE");
        
        if(generatedArrayNumber != null){
            for(int ix = 0; ix < originalData.length; ix++){
                for(int i = 0; i < originalData[ix].length; i++) {
                    System.out.print(originalData[ix][i] + "  ");
                }
                System.out.println("");
            }
        } else {
        }
        
        // UPDATE CORE DATA MULTIDIMENSIONAL ARRAY
        System.out.println("");
        for(int ix = 0 ; ix < occupiedCoordinateX.length; ix++){
            originalData[occupiedCoordinateX[ix]][occupiedCoordinateY[ix]] = occupiedValue[ix];
            //System.out.println("originaldata["+occupiedCoordinateX[ix]+"]["+occupiedCoordinateY[ix]+"] = valueNumber["+occupiedValue[ix]+"]");
        }
        
        System.out.println("\nAFTER");
        
        if(generatedArrayNumber != null){
            for(int ix = 0; ix < originalData.length; ix++){
                for(int i = 0; i < originalData[ix].length; i++) {
                    System.out.print(originalData[ix][i] + "  ");
                }
                System.out.println("");
            }
        } else {
        }
         
        return originalData;
    }
    
    public static void main(String[] args) {
        DAO_RandomNumberGenerator DRNG = new DAO_RandomNumberGenerator();
        DRNG.invokeClassFunctions(9, 9, 23, 20,"3375031609910019");
    }
    
    public List<MOD_Override_QR_Data> invokeClassFunctions(int x, int y, int tpsID, int pengawasID, String KTPID){
        // Generated Digit
        long start_time = System.currentTimeMillis();
        
        DAO_RandomNumberGenerator DRNG = new DAO_RandomNumberGenerator();
        List<MOD_Override_QR_Data> MQRD = new ArrayList<MOD_Override_QR_Data>();
        MOD_Override_QR_Data modOQD = new MOD_Override_QR_Data();
        
        List<MOD_RandomNumberGenerator> arrayNumber = DRNG.RandomGenerator(x, y);
//        System.out.println("=========== TPS ===========");
        int[] cobaArrayTPS = DRNG.UniqueNumberConverter(tpsID);
        
//        System.out.println("\n=========== PENGAWAS ===========");
        int[] cobaArrayPENGAWAS = DRNG.UniqueNumberConverter(pengawasID);
        
        //System.out.println("\n=========== KTP ===========");
        KTPID = KTPID.replaceAll("\\s+","");
        String[] explodedKTPID = KTPID.split("");
        String voteLocation = "";
        voteLocation = KTPID.substring(0,6);
        int sumKTPID = 0;
        for(int it = 1; it < explodedKTPID.length; it++){
            sumKTPID += Integer.parseInt(explodedKTPID[it]);
        }
        
        boolean existedKTPNO = true;
        List<MOD_KTP_Data> LMKD = null;
        try {
            LMKD = new DAO_KTP_Data((new DB_Connection()).getConnection()).RetrieveKTPData();
            existedKTPNOloop:
            if(LMKD != null){
                for(MOD_KTP_Data cc : LMKD){
                    String listedKTP = cc.getKtp_no();
                    System.out.println("DEBUG KTP NO : "+listedKTP+" == "+KTPID);
                    if(listedKTP.equals(KTPID)){
                        existedKTPNO = false;
                        break existedKTPNOloop;
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(DAO_RandomNumberGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(existedKTPNO == true){
            DRNG.generateKeyKTP(sumKTPID);
        } else {
            JOptionPane.showMessageDialog(null, "ID KTP sudah didaftarkan, Program Restart.", "Error Duplikasi.", JOptionPane.ERROR_MESSAGE);
            // ERROR STOPPER PROGAM - change to stop process interupt
            System.exit(1);
        }
                
        int[][] updatedNumber = null;
        updatedNumber = DRNG.UpdateValueData(occupiedCoordinateX, occupiedCoordinateY, occupiedValue, arrayNumber);
        
        modOQD.setRandomNumber(updatedNumber);
        MQRD.add(modOQD);
        
        // Variables for insert data into database
            List<MOD_Key> MK = DRNG.getKeyPublic();
            String[] tpsKey = new String[5];
            int sumTpsKey = 0;
            int tpsCount = 0;
            
            String[] pengawasKey = new String[5];
            int sumPengawasKey = 0;
            int pengawasCount = 0;
            
            // countable array length
            int lengthArrayKTP = MK.size()-10;
            String[] ktpKey = new String[lengthArrayKTP];
            int sumKtpKey = 0;
            int ktpCount = 0;
            
            int ixx = 0;
            for (MOD_Key c : MK) {
                System.out.println("ixx: "+ixx+" val : "+c.getOccupiedValueMK()+" X : "+c.getOccupiedCoordinatesXMK()+" Y : "+c.getOccupiedCoordinatesYMK()+" str : "+c.getOccupiedCoordinatesMK());
                if(ixx < 5){
                    tpsKey[tpsCount] = c.getOccupiedCoordinatesMK();
                    sumTpsKey += c.getOccupiedValueMK();
                    tpsCount++;
                } else if (ixx >= 5 && ixx < 10){
                    pengawasKey[pengawasCount] = c.getOccupiedCoordinatesMK();
                    sumPengawasKey += c.getOccupiedValueMK();
                    pengawasCount++;
                } else if (ixx >= 10){
                    ktpKey[ktpCount] = c.getOccupiedCoordinatesMK();
                    sumKtpKey += c.getOccupiedValueMK();
                    ktpCount++;
                }
                ixx++;
            }
            
            try {
                // call DAO KEY as database controller
                int tpsLastID = new DAO_Key((new DB_Connection()).getConnection()).InputTpsKeyValue(tpsKey, sumTpsKey, tpsCount);
                int pengawasLastID = new DAO_Key((new DB_Connection()).getConnection()).InputPengawasKeyValue(pengawasKey, sumPengawasKey, pengawasCount);
                int ktpLastID = new DAO_Key((new DB_Connection()).getConnection()).InputKTPKeyValue(ktpKey, sumKtpKey, ktpCount);
                // end of call DAO KEY

                // begin build raw data
                String rawData = "";
                for(int ia = 0; ia < updatedNumber.length; ia++){
                    for(int iaa = 0; iaa < updatedNumber[ia].length; iaa++){
                        rawData += updatedNumber[ia][iaa];
                    }
                }
                System.out.println("raw data : \n"+rawData);
                // call DAO DATA as raw data controller
                int qrDataLastID = new DAO_Data((new DB_Connection()).getConnection()).SaveQRData(rawData);
                // end of call DAO DATA
                // call DAO KTP DATA as compare data, prevent double generate
                new DAO_KTP_Data((new DB_Connection()).getConnection()).SaveKTPData(KTPID);
                // end of call DAO KTP DATA
                // call DAO KEY to SAVE LINKED DATA used for WEB SERVICE RETURN KEY
                new DAO_Key((new DB_Connection()).getConnection()).InputLinkedKeyData(ktpLastID, tpsLastID, pengawasLastID, qrDataLastID, voteLocation);
                // end of call DAO KEY
                // call of validate Devices - DAO_VALIDATOR
                boolean isExistingTPSandPengawasNumber = new DAO_Validator((new DB_Connection()).getConnection()).FindExistingVoteLocation(voteLocation, sumTpsKey, sumPengawasKey);
                if(isExistingTPSandPengawasNumber == true){
                    new DAO_Validator((new DB_Connection()).getConnection()).SaveInitialData(voteLocation, sumTpsKey, sumPengawasKey);
                } else {
                    // nothing
                }
                // end of call DAO_VALIDATOR

                System.out.println("SUM KTP : "+sumKTPID);
                long end_time = System.currentTimeMillis();
                long execution_time = end_time - start_time;
                System.out.println("\n> Running Time : "+execution_time+" ms | or : "+execution_time/1000+" seconds");
            } catch (IOException ex) {
                Logger.getLogger(DAO_RandomNumberGenerator.class.getName()).log(Level.SEVERE, null, ex);
            }
        return MQRD;
    }
    
    public List<MOD_Key> getKeyPublic(){
        List<MOD_Key> MKey = new ArrayList<MOD_Key>();
        int[] occupiedValueL = occupiedValue;
        int[] occupiedCoordinateXL = occupiedCoordinateX;
        int[] occupiedCoordinateYL = occupiedCoordinateY;
        String[] occupiedCoordinateL = occupiedCoordinate;
        
        for(int ix = 0; ix < occupiedValueL.length; ix++){
            MOD_Key MK = new MOD_Key();
            if(occupiedCoordinateL[ix] != null){
                MK.setOccupiedValueMK(occupiedValueL[ix]);
                MK.setOccupiedCoordinatesXMK(occupiedCoordinateXL[ix]);
                MK.setOccupiedCoordinatesYMK(occupiedCoordinateYL[ix]);
                MK.setOccupiedCoordinatesMK(occupiedCoordinateL[ix]);
                MKey.add(MK);
            }
        }
        
        return MKey;
    }
}
