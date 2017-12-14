package org.volhvporechja.demo.aspects;

import org.springframework.stereotype.Service;

@Service
public class SomeService implements SomeServiceContract {

	@Override
	@Nuance
	public String SomeModification(String modifyingString) {
		return String.format("FUCK%sFUCK", modifyingString);
	}

	@Override
	@Nuance
	public String SomeGeneration() {
		return "FUCK YOU!!";
	}
}
