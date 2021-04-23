package kz.tlegenov.dentalserver.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "record")
public class Record {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;  
	private String dateTime;
	private String comment;
	private int duration;    // time for procedure
	private int status;   
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
	@JsonBackReference               // �������� �������
	private Patient patient;
	
	public Record() {}
	
	public Record(String dateTime) {
		this.dateTime = dateTime;
	}

	public Long getId() { 
		return id; 
	}

	public void setId(Long id) { 
		this.id = id; 
	}

	public String getDateTime() { 
		
		return dateTime.substring(0,16); 
	}
	
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getComment() { 
		return comment; 
	}

	public void setComment(String comment) { 
		this.comment = comment; 
	}
	
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Patient getPatient() { 
		return patient; 
	}

	public void setPatient(Patient patient) { 
		this.patient = patient; 
	}
	
/*****************************************************************************/	
	public String getHoursMinuts(){
		String  hhmm = dateTime.substring(11,16);
		return hhmm;
	}
	
	public int getMinutes() {
		String  hhmm = dateTime.substring(11,16);
		String[] strMinut = hhmm.split(":");
		int minuts = Integer.parseInt(strMinut[0])*60 + Integer.parseInt(strMinut[1]);
		return minuts;
	}
	
	public String getRowColor() {
		if(duration == 1) 
			return "#9be096";
		
		if(duration == 2)
			return "#faa887";
		else{
			return null;
		}
	}
	
	public String getPatientName(){
		if(patient == null) {
			return "";
		}else {
			return patient.getName();
		}
	}
}
