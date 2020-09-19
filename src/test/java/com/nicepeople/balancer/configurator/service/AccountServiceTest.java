package com.nicepeople.balancer.configurator.service;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AccountServiceTest {

//	@Autowired
//	private IMeetService meetService;
//
//	@Autowired
//	private IAccountRepository meetRepository;
//
//	@Autowired
//	private IMongoAccountRepository iMongoMeetRepository;
//
//	private static final LocalDate DATE_Meet = LocalDate.now();
//
//	@Before
//	public void setUp() {
//		iMongoMeetRepository.deleteAll();
//	}
//
//	@Test
//	public void createMeetSuccess() {
//		MeetDTO meetDTO = buildMeetDTO();
//		Meet newMeet = meetService.createNewMeet(meetDTO);
//		Meet meetSaved = getMeetSave();
//		Assert.assertEquals(3, newMeet.getGuests().size());
//		// Asserts de que la meet up contiene los invitados que se mandaron a guardar
//		Assert.assertTrue(meetSaved.getGuests().stream().anyMatch(meetGuest -> meetGuest.getId().equals("2")));
//		Assert.assertTrue(meetSaved.getGuests().stream().anyMatch(meetGuest -> meetGuest.getId().equals("3")));
//		Assert.assertTrue(meetSaved.getGuests().stream().anyMatch(meetGuest -> meetGuest.getId().equals("4")));
//	}
//
//	@Test(expected = DuplicateEntityException.class)
//	public void createSameMeetTwice() {
//		this.createMeetSuccess();
//		this.createMeetSuccess();
//	}
//
//	@Test
//	public void closeMeetSuccess() {
//		this.createMeetSuccess();
//		Meet meetSaved = getMeetSave();
//		this.meetService.closeMeet(meetSaved.getId());
//		meetSaved = getMeetSave();
//		Assert.assertTrue(meetSaved.getBeersAmount() != null);
//	}
//
//	@Test
//	public void getAllMeetsSuccess() {
//		this.createMeetSuccess();
//		MeetDTO meetDto = buildMeetDTO();
//		meetDto.setDate(LocalDate.now().plusDays(1));
//		meetService.createNewMeet(meetDto);
//		Assert.assertEquals(2, meetRepository.getAll().size());
//	}
//
//	@Test
//	public void getBeersBoxAmount() {
//		this.closeMeetSuccess();
//		Meet meetSaved = getMeetSave();
//		Assert.assertTrue(meetSaved.getBeersAmount() == 6);
//		BeerDTO beerDto = this.meetService.getBeerBoxesAmount(meetSaved.getId());
//		// Al ser 6 birras, se necesita una caja de birras
//		Assert.assertEquals(Integer.valueOf(1), beerDto.getBeerBoxes());
//	}
//
//	@Test(expected = ValidationException.class)
//	public void getBeersBoxAmountWithMeetNotClosed() {
//		this.createMeetSuccess();
//		Meet meetSaved = getMeetSave();
//		this.meetService.getBeerBoxesAmount(meetSaved.getId());
//	}
//
//	@Test
//	public void getTemperatureTest() {
//		this.createMeetSuccess();
//		Meet meetSaved = getMeetSave();
//		TemperatureDTO temperatureDto = this.meetService.getTemperature(meetSaved.getId());
//		Assert.assertEquals(Double.valueOf("28.04"), temperatureDto.getTemperature());
//	}
//
//	@Test
//	public void joinMeetSuccessful() {
//		this.createMeetSuccess();
//		Meet meetSaved = getMeetSave();
//		// Assert de que la primer meet tiene 3 usuarios guardados
//		Assert.assertEquals(3, meetSaved.getGuests().size());
//		// Se agrega el usuario con id 5 a la meet
//		this.meetService.addUser(meetSaved.getId(), "5");
//		// Despues de unirse a la meet, pasa a tener 4 invitados
//		meetSaved = getMeetSave();
//		Assert.assertEquals(4, meetSaved.getGuests().size());
//		Assert.assertTrue(meetSaved.getGuests().stream().anyMatch(meetGuest -> meetGuest.getId().equals("5")));
//	}
//
//	@Test
//	public void checkinUser() {
//		this.createMeetSuccess();
//
//		Meet meetSaved = getMeetSave();
//		Assert.assertEquals(3, meetSaved.getGuests().size());
//
//		User user = meetSaved.getGuests().iterator().next();
//		Assert.assertFalse(user.isCheckin());
//
//		this.meetService.closeMeet(meetSaved.getId());
//		this.meetService.checkinUser(meetSaved.getId(), user.getId());
//
//		meetSaved = getMeetSave();
//		Optional<User> userOption = meetSaved.getGuests().stream().filter(u -> u.getId().equals(user.getId()))
//				.findFirst();
//		Assert.assertTrue(userOption.isPresent());
//		Assert.assertTrue(userOption.get().isCheckin());
//	}
//
//	private Meet getMeetSave() {
//		List<Meet> meets = meetRepository.getAll();
//		Meet meetSaved = meets.stream().filter(meet -> meet.getDate().isEqual(DATE_Meet)).findFirst().get();
//		return meetSaved;
//	}
//
//	private MeetDTO buildMeetDTO() {
//		MeetDTO meetDto = new MeetDTO(DATE_Meet, Lists.newArrayList("2", "3", "4"));
//		return meetDto;
//	}
}
