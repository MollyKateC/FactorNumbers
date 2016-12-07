package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Run100JobsOnCluster {
    
    public static final File ResultsDirectory = new File("/users/mcrowde8/test/Results");
    public static final File scriptToRun = new File(ResultsDirectory.getAbsolutePath() + "/scriptToRun.sh");

    public static void main(String[] args) throws Exception {
	
	BufferedWriter writeScript = new BufferedWriter(new FileWriter(scriptToRun.getAbsolutePath()));
	int timesToRun = 10;

	for(int i = 0; i < timesToRun; i++){
	    File filename = new File(ResultsDirectory.getAbsolutePath() + File.separator + "/file" + ".bat");
	    String outFile = "out" + i + ".txt";
	    BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
	    File outfile = new File(ResultsDirectory.getAbsolutePath() + File.separator + outFile);

	    writer.write("java -jar /users/mcrowde8/test/FactorNumbers/FactorNumbers/FactorNumbersSingleThread.jar " + outfile.getAbsolutePath().toString());
	    writer.newLine();
	    writer.flush();
	    writer.close();

	    writeScript.write("qsub " + filename.getAbsolutePath());
	    writeScript.newLine();
	}
	writeScript.flush();
	writeScript.close();
    }

}