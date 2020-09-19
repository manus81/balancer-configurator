package com.nicepeople.balancer.configurator.domain.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicepeople.balancer.configurator.domain.model.Account;
import com.nicepeople.balancer.configurator.domain.model.Host;
import com.nicepeople.balancer.configurator.domain.model.TargetDevice;
import com.nicepeople.balancer.configurator.domain.repository.IAccountRepository;

@Service
public class AccountService implements IAccountService {

	private final IAccountRepository accountRepository;

	@Autowired
	public AccountService(final IAccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public Account createAccount(final String accountCode, final Set<TargetDevice> targetDevices) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccount(final String accountCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getAllAccounts() {
		return this.accountRepository.getAll();
	}

	@Override
	public Account updateAccount(final Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTargetDevice(final String accountCode, final TargetDevice targetDevice) {
		// TODO Auto-generated method stub
	}

	@Override
	public void addHost(final String accountCode, final String device, final Host host) {
		// TODO Auto-generated method stub
	}

//	public Account createNewMeet(final MeetDTO meetDTO) {
//		if (this.accountRepository.existsByDate(meetDTO.getDate())) {
//			throw new DuplicateEntityException("A meet has already saved for this date: " + meetDTO.getDate());
//		}
//
//		final WeatherDTO weatherDTO = weatherService.getWeatherInfo();
//		final Meet meet = new Meet(meetDTO.getGuestIds(), meetDTO.getDate(), weatherDTO.getTemp());
//		return this.accountRepository.save(meet);
//	}
//
//	public void closeMeet(final String meetingId) {
//		final Meet meet = this.accountRepository.get(meetingId);
//		meet.close();
//		this.accountRepository.save(meet);
//	}
//
//	public TemperatureDTO getTemperature(final String meetingId) {
//		final Meet meet = this.accountRepository.get(meetingId);
//		return new TemperatureDTO(meet.getTemperature());
//	}
//
//	public BeerDTO getBeerBoxesAmount(final String meetingId) {
//		final Meet meet = this.accountRepository.get(meetingId);
//
//		if (!meet.isClosed()) {
//			throw new ValidationException(String.format("The meet wih id: %s is not closed", meet.getId()));
//		}
//
//		final Integer beerBoxesAmount = BeerAmountCalculatorService.calculateBeerBoxes(meet.getBeersAmount());
//		return new BeerDTO(beerBoxesAmount);
//	}
//
//	public void addUser(final String meetId, final String userId) {
//		final Meet meet = this.accountRepository.get(meetId);
//		meet.addGuest(new User(userId));
//		this.accountRepository.save(meet);
//	}
//
//	public void checkinUser(final String meetId, final String userId) {
//		final Meet meet = this.accountRepository.get(meetId);
//		meet.userChecking(userId);
//		this.accountRepository.save(meet);
//	}
}
