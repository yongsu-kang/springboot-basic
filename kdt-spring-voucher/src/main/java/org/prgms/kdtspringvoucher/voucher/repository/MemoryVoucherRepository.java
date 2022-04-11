package org.prgms.kdtspringvoucher.voucher.repository;

import org.prgms.kdtspringvoucher.voucher.domain.Voucher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Profile("default")
public class MemoryVoucherRepository implements VoucherRepository{

    private static final Logger logger = LoggerFactory.getLogger(MemoryVoucherRepository.class);
    private Map<UUID, Voucher> store = new ConcurrentHashMap<>();

    @Override
    public Voucher save(Voucher voucher) {
        logger.info("Succeed save Voucher Data => {}", voucher);
        return store.put(voucher.getVoucherID(),voucher);
    }

    @Override
    public Optional<Voucher> findById(UUID voucherId) {
        Optional<Voucher> findVoucher = Optional.ofNullable(store.get(voucherId));
        logger.info("Search by voucherId => {}", voucherId);
        logger.info("Find Voucher by voucherId => {}", findVoucher);
        return findVoucher;
    }

    @Override
    public List<Voucher> findAll() {
        logger.info("Find All Saved vouchers");
        return store.keySet()
                .stream()
                .map(key -> store.get(key))
                .toList();
    }
}