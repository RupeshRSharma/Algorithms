package com.intelizest;



import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.*;

class Reconciler {

    Stream<PendingTransaction> reconcile(Stream<PendingTransaction> pending, Stream<Stream<ProcessedTransaction>> processed) {
        if(pending == null && processed == null) {
            return Stream.empty();
        }
        
        
        Supplier<Stream<ProcessedTransaction>> newprocessed = () -> processed.flatMap(p -> p);
        List<Long>  filteredProcessedId = processed.flatMap(p -> p)
                .filter(Objects::nonNull)
                .filter(p -> p.getStatus() != null && "DONE".equalsIgnoreCase(p.getStatus().get()))
                .filter(p -> p.getId() != null && p.getId().length() > 0)
                .map(p -> Long.parseLong(p.getId())).collect(Collectors.toList());
System.out.println(filteredProcessedId);
//Stream.of(filteredProcessedId).anyMatch();
        return pending.filter(p -> Stream.of(filteredProcessedId).anyMatch(pr -> pr.equals(p.getId())));
    }
    
    
    public static void main(String[] args) {
    	
    	
    	PendingTransaction pending = new PendingTransaction();
    	pending.setId(1L);
    	pending.setStatus("Done");
    	
    	ProcessedTransaction processed = new ProcessedTransaction();
    	processed.setId("1");    	
    	processed.setStatus( Optional.ofNullable("Done"));
    	ProcessedTransaction processed2 = new ProcessedTransaction();
    	processed2.setId("2");    	
    	processed2.setStatus( Optional.ofNullable("Done"));
    	List<ProcessedTransaction> list = new ArrayList<>();
    	list.add(processed);
    	list.add(processed2);
    	
    	Reconciler recon = new Reconciler();
    	//recon.reconcile(Stream.of(pending), Stream.of(Stream.of(list))).forEach(System.out::print);
    	
    }

}

class PendingTransaction{
	private String status;
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	private Long id;
}

class ProcessedTransaction{
	private Optional<String> status;
	private String id;
	/**
	 * @return the status
	 */
	public Optional<String> getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Optional<String> status) {
		this.status = status;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
}
