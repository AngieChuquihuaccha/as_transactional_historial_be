package com.transactional.demo_soa.service.impl;

import com.transactional.demo_soa.domain.dto.Attendance.MasivAtten;
import com.transactional.demo_soa.domain.dto.DataTransactionalSimpleHistorial;
import com.transactional.demo_soa.domain.dto.TransactionalSimple.TransactionalSimpleResponseDto;
import com.transactional.demo_soa.domain.mapper.TransactionalSimpleMapper;
import com.transactional.demo_soa.repository.TransactionalSimpleRepository;
import com.transactional.demo_soa.service.TransactionalSimpleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.transactional.demo_soa.domain.mapper.TransactionalSimpleMapper.toModel;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionalSimpleImpl implements TransactionalSimpleService {



    final TransactionalSimpleRepository transactionalSimpleRepository;


    @Override
    public Flux<TransactionalSimpleResponseDto> getDataFullComplete() {
        return this.transactionalSimpleRepository.findAll()
                .map(TransactionalSimpleMapper::toDto);
    }

    @Override
    public Flux<DataTransactionalSimpleHistorial> findAll() {
        return null;
    }

    @Override
    public Mono<Void> saveNewData(MasivAtten request) {
        Flux<Void> saveOperations = Flux.fromIterable(request.getId_attendance())
                .flatMap(res -> {
                    TransactionalSimpleResponseDto trans = TransactionalSimpleResponseDto.builder()
                            .id_attendance(res.getId_attendance())
                            .build();

                    return transactionalSimpleRepository.save(toModel(trans)).then();
                });

        return saveOperations.then();
    }
}
