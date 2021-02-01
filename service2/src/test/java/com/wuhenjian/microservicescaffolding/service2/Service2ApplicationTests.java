package com.wuhenjian.microservicescaffolding.service2;

import com.wuhenjian.microservicescaffolding.util.domain.entity.A;
import com.wuhenjian.microservicescaffolding.util.domain.entity.B;
import com.wuhenjian.microservicescaffolding.util.domain.entity.C;
import com.wuhenjian.microservicescaffolding.util.mapper.AMapper;
import com.wuhenjian.microservicescaffolding.util.mapper.BMapper;
import com.wuhenjian.microservicescaffolding.util.mapper.CMapper;
import com.wuhenjian.microservicescaffolding.util.repository.ARepository;
import com.wuhenjian.microservicescaffolding.util.repository.BRepository;
import com.wuhenjian.microservicescaffolding.util.repository.CRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Service2ApplicationTests {
	@Autowired
	private AMapper aMapper;
	@Autowired
	private BMapper bMapper;
	@Autowired
	private CMapper cMapper;
	@Autowired
	private ARepository aRepository;
	@Autowired
	private BRepository bRepository;
	@Autowired
	private CRepository cRepository;

	@Test
	public void insert() {
		List<A> aList = new ArrayList<>(10);
		List<B> bList = new ArrayList<>(100);
		List<C> cList = new ArrayList<>(1000);
		for (int i = 1; i < 11; i++) {
			A a = new A();
			a.setAid(i);
			a.setAname(new String(new char[]{(char) i}));
			a.setAtime(new Date());
			aList.add(a);
			for (int j = 1; j < 11; j++) {
				B b = new B();
				b.setAid(i);
				int bid = i * 10 + j;
				b.setBid(bid);
				b.setBname(new String(new char[]{(char) bid}));
				b.setBtime(new Date());
				bList.add(b);
				for (int k = 0; k < 11; k++) {
					C c = new C();
					c.setBid(bid);
					int cid = j * 10 + k;
					c.setCid(cid);
					c.setCname(new String(new char[]{(char) cid}));
					c.setCtime(new Date());
					cList.add(c);
				}
			}
		}

		aRepository.saveBatch(aList);
		bRepository.saveBatch(bList);
		cList.stream()
				.collect(Collectors.groupingBy(C::getBid))
				.forEach((bId, cs) -> cRepository.saveBatch(cs));
	}
}
