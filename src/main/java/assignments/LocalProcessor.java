package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private Long period = 10_000_000_000_000L;
    private StringBuilder processorVersion;
    private Integer valueOfCheap;
    private List<String> stringList = new LinkedList<>();

    public LocalProcessor(String processorName, Long period, StringBuilder processorVersion,
                          Integer valueOfCheap, LinkedList<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.stringList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(LinkedList<String> stringList) {
        for (String str : stringList) {
            System.out.println(str.hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessOrGenerator(LinkedList<String> stringList) {
        if (stringList == null) {
            return " ";
        }
        for (String str : stringList) {
            processorVersion.append(str).append(" ");
        }
        processorName = String.valueOf(processorVersion);
        return processorName;
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessOrName(File file) {
        try (Scanner informationScanner = new Scanner(file)){
            while (informationScanner.hasNext()) {
                processorVersion.append(informationScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.fillInStackTrace();
        }
    }
}
