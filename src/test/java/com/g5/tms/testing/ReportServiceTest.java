package com.g5.tms.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.g5.tms.entities.Customer;
import com.g5.tms.entities.Feedback;
import com.g5.tms.entities.Report;
import com.g5.tms.exceptions.FeedbackNotFoundException;
import com.g5.tms.exceptions.ReportNotFoundException;
import com.g5.tms.repository.IReportRepository;
import com.g5.tms.service.IReportService;

@SpringBootTest
@ActiveProfiles("test8")
public class ReportServiceTest {
	@Autowired
	IReportRepository reportRepository;
	@Autowired
	IReportService reportService;

	@Test
	public void testReportById() throws ReportNotFoundException {
		Report rep = new Report(12, "vvvvuu", "reportType", null);
		Optional<Report>opt=Optional.of(rep);
		Mockito.when(reportRepository.findById(12)).thenReturn(opt);
		Report test_rep = reportService.viewReport(12);
		assertEquals(rep, test_rep);
	}
	@Test
	public void testAddREport() {
		Report rep = new Report(12, "vvvvuu", "reportType", null);
		Mockito.when(reportRepository.save(rep)).thenReturn(rep);
		Report test_rep = reportService.addReport(rep);
		assertEquals(rep, test_rep);
		
	}
	
	@Test
	public void testAllReport() {
		
		Report rep = new Report(12, "vvvvuu", "reportType", null);
		List<Report> rep_list = Arrays.asList(rep);
		Mockito.when(reportRepository.findAll()).thenReturn(rep_list);
		List<Report> actual_replist = reportService.viewAllReports();
		assertEquals(rep_list, actual_replist);
	}

	@Test
	public void testDeleteReportbyId() throws ReportNotFoundException {

		Report rep = new Report(12, "vvvvuu", "reportType", null);
		Optional<Report> opt = Optional.of(rep);
		reportRepository.save(rep);
		reportRepository.delete(rep);
		Mockito.when(reportRepository.findById(12)).thenReturn(opt);
		
		Report test_rep = reportService.deleteReport(12);
		assertEquals(rep, test_rep);
		
	}
	
	@Test
	void testReportNotFoundexception() {
		Report rep = new Report(12, "vvvvuu", "reportType", null);
		Optional<Report> report = Optional.of(rep);
		when(reportRepository.findById(12)).thenReturn(report);
		Executable executable = ()->reportService.viewReport(14);
		assertThrows(ReportNotFoundException.class, executable);
	}

}
