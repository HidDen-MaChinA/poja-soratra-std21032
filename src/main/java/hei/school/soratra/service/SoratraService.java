package hei.school.soratra.service;

import hei.school.soratra.endpoint.rest.controller.client.GetSoratra;
import hei.school.soratra.file.BucketComponent;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

@Service
@AllArgsConstructor
public class SoratraService {
    private final BucketComponent bucketComponent;
    public String saveSoratra(String id, String soratra){
        File file1 = new File("temp.txt");
        File file2 = new File("temp2.txt");
        try{
            FileWriter writer1 = new FileWriter(file1);
            FileWriter writer2 = new FileWriter(file2);
            writer1.append(soratra);
            writer2.append(soratra.toUpperCase());
            bucketComponent.upload(file1,id+"_lower.txt");
            bucketComponent.upload(file2,id+"_upper.txt");
            return "sent";
        }catch (IOException e){
            System.out.println("an exception");
            return null;
        }
    }
    public GetSoratra getSoratra(String id){
        Duration duration = Duration.ofMinutes(10);
        URL original = bucketComponent.presign(id+"_lower.txt", duration);
        URL transformed = bucketComponent.presign(id+"_upper.txt", duration);
        return GetSoratra.builder().original_url(original.toString()).transformed_url(transformed.toString()).build();
    }
}
