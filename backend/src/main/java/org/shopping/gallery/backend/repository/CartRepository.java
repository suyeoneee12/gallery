package org.shopping.gallery.backend.repository;

import org.shopping.gallery.backend.entity.Cart;
import org.shopping.gallery.backend.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findByMemberId(int memberId);

    Cart findByMemberIdAndItemId(int memberId, int itemId);
}
