package com.nahwasa.springsecuritybasicsettingforspringboot3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nahwasa.springsecuritybasicsettingforspringboot3.domain.Member;
import com.nahwasa.springsecuritybasicsettingforspringboot3.repository.MemberRepository;

@Service
public class RegisterMemberService {
	private final MemberRepository repository;

	@Autowired
	public RegisterMemberService(MemberRepository repository) {
		this.repository = repository;
	}

	public Long join(String email, String password) {
		Member member = Member.createUser(email, password);
		validateDuplicateMember(member);
		repository.save(member);

		return member.getMemberId();
	}

	private void validateDuplicateMember(Member member) {
		repository.findByEmail(member.getEmail())
			.ifPresent(m -> {
				throw new IllegalStateException("이미 존재하는 회원입니다.");
			});
	}
}
