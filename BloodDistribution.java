import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
public class BloodDistribution {
    public static void main(String[] args)
            throws IOException
    {

        int[] patients = new int[8];
        int[] blood = new int[8];
        // patients: ONegPatient, OPosPatient, ANegPatient, APosPatient, BNegPatient, BPosPatient, ABNegPatient, ABPosPatient
        // blood: ONegBlood, OPosBlood, ANegBlood, APosBlood, BNegBlood, BPosBlood, ABNegBlood, ABPosBlood

        InputStream in;
        if (args.length == 1) {
            in = new FileInputStream(args[0]);
        } else {
            in = System.in;
        }
        Scanner s = new Scanner(in);
        for (int i = 0 ; i < 8 ; i++) {
            blood[i] = s.nextInt();
        }
        for (int i = 0 ; i < 8 ; i++) {
            patients[i] = s.nextInt();
        }
        if (args.length == 1) {
            in.close();
        }

        int received = 0;

        // O negative patients can receive O negative blood
        received += matchBlood(patients, blood, 0, 0);
        // O positive patients can receive O positive and O negative blood
        received += matchBlood(patients, blood, 1, 1);
        received += matchBlood(patients, blood, 1, 0);
        // A negative patients can receive A negative and O negative blood
        received += matchBlood(patients, blood, 2, 2);
        received += matchBlood(patients, blood, 2, 0);
        // A positive patients can receive A positive, A negative, O positive, and O negative blood
        received += matchBlood(patients, blood, 3, 3);
        received += matchBlood(patients, blood, 3, 2);
        received += matchBlood(patients, blood, 3, 1);
        received += matchBlood(patients, blood, 3, 0);
        // B negative patients can receive B negative and O negative blood
        received += matchBlood(patients, blood, 4, 4);
        received += matchBlood(patients, blood, 4, 0);
        // B positive patients can receive B positive, B negative, O positive, and O negative blood
        received += matchBlood(patients, blood, 5, 5);
        received += matchBlood(patients, blood, 5, 4);
        received += matchBlood(patients, blood, 5, 1);
        received += matchBlood(patients, blood, 5, 0);
        // AB negative patients can receive any Rh-negative blood
        received += matchBlood(patients, blood, 6, 6);
        received += matchBlood(patients, blood, 6, 4);
        received += matchBlood(patients, blood, 6, 2);
        received += matchBlood(patients, blood, 6, 0);
        // AB positive patients can receive any type of blood
        received += matchBlood(patients, blood, 7, 7);
        received += matchBlood(patients, blood, 7, 6);
        received += matchBlood(patients, blood, 7, 5);
        received += matchBlood(patients, blood, 7, 4);
        received += matchBlood(patients, blood, 7, 3);
        received += matchBlood(patients, blood, 7, 2);
        received += matchBlood(patients, blood, 7, 1);
        received += matchBlood(patients, blood, 7, 0);

        System.out.println(received);
    }

    private static int matchBlood(int[] patients, int[] blood, int patientType, int bloodType) {
        int matched = Math.min(patients[patientType], blood[bloodType]);
        patients[patientType] -= matched;
        blood[bloodType] -= matched;
        return matched;
    }

}