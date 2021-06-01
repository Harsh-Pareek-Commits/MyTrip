package com.g5.tms.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.g5.tms.entities.Report;
import com.g5.tms.exceptions.ReportNotFoundException;
import com.g5.tms.repository.IReportRepository;
import com.g5.tms.service.IReportService;

@SpringBootTest
@ActiveProfiles("test8")
public class ReportServiceTest {
	@Autowired
	IReportRepository report_repo;
	@Autowired
	IReportService report_serv;

	@Test
	public void testReportById() throws ReportNotFoundException {
		Report rep = new Report(12, "vvvvuu", "reportType", null);
		Optional<Report>opt=Optional.of(rep);
		Mockito.when(report_repo.findById(12)).thenReturn(opt);
		Report test_rep = report_serv.viewReport(12);
		assertEquals(rep, test_rep);
	}
	@Test
	public void testAddREport() {
		Report rep = new Report(12, "vvvvuu", "reportType", null);
		Mockito.when(report_repo.save(rep)).thenReturn(rep);
		Report test_rep = report_serv.addReport(rep);
		assertEquals(rep, test_rep);
		
	}
	
	@Test
	public void testAllReport() {
		
		Report rep = new Report(12, "vvvvuu", "reportType", null);
		List<Report> rep_list = Arrays.asList(rep);
		Mockito.when(report_repo.findAll()).thenReturn(rep_list);
		List<Report> actual_replist = report_serv.viewAllReports();
		assertEquals(rep_list, actual_replist);
	}

	@Test
	public void testDeleteReportbyId() throws ReportNotFoundException {

		Report rep = new Report(12, "vvvvuu", "reportType", null);
		Optional<Report> opt = Optional.of(rep);
		report_repo.save(rep);
		report_repo.delete(rep);
		Mockito.when(report_repo.findById(12)).thenReturn(opt);
		
		Report test_rep = report_serv.deleteReport(12);
		assertEquals(rep, test_rep);
		
	}

}
