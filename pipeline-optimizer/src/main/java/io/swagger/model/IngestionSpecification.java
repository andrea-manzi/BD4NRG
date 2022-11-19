package io.swagger.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("druidIngestionSpec")
public class IngestionSpecification {

    @Id
    private String id;
    private String urn;
    private String IngestionSpec;
    private String druidIngestionSpecID;

    public IngestionSpecification (String id,String urn, String IngestionSpec, String druidIngestionSpecID) {

        super();
        this.id = id;
        this.urn = urn;
        this.IngestionSpec = IngestionSpec;
        this.druidIngestionSpecID = druidIngestionSpecID;

    }

    public String getUrn() {
        return this.urn;
    }
    public String getIngestionSpec() {
        return this.IngestionSpec;
    }
    public String druidIngestionSpecID() {
        return this.druidIngestionSpecID;
    }
    
}
