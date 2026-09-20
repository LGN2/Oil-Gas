# Debugging Log

| Error / rule | HTTP status | Cause | Fix |
|---|---:|---|---|
| Missing or soft-deleted resource | 404 | Requested ID is unavailable | Active-only repository lookups throw ResourceNotFoundException |
| Invalid DTO | 400 | Bean-validation constraint failed | @Valid DTO constraints match entity column limits |
| Negative production | 400 | Invalid field reading | Production operation rejects negative volumes |
| Production on non-producing well | 400 | Well status is not PRODUCING | Business service validates well state |
| Rig double assignment | 400 | Rig already belongs to another active well | Assignment operation checks active wells |
| Tank over capacity | 400 | Transfer exceeds capacity | Transfer is rejected before currentLevel changes |
| Shipment exceeds stock | 400 | Shipment volume exceeds currentLevel | Dispatch rejects request and leaves level unchanged |
| Invalid inspection target | 400 | Both/neither well and pipeline supplied | Exactly one target is required |
| Inspection too far in future | 400 | Date exceeds configured 90-day window | Inspection scheduling rejects it |
| Incident reporter mismatch | 400 | Personnel is assigned to another field | Field membership is validated |
| Entity JSON recursion risk | N/A | Bidirectional JPA relationships | Controllers expose DTOs, never raw entities |
| Credentials in source | N/A | Hard-coded DB credentials are unsafe | DB_USERNAME and DB_PASS environment variables |
