DELETE FROM pub_bcr_candiattr WHERE pk_nbcr = '0001ZZ1000000009RZOZ';
DELETE FROM pub_bcr_elem WHERE pk_billcodebase in ( select pk_billcodebase from pub_bcr_RuleBase where nbcrcode = 'YSDJ' );
DELETE FROM pub_bcr_RuleBase WHERE nbcrcode = 'YSDJ';
DELETE FROM pub_bcr_nbcr WHERE pk_nbcr = '0001ZZ1000000009RZOZ';
DELETE FROM pub_bcr_OrgRela WHERE pk_billcodebase = '0001ZZ1000000009RZP0';
DELETE FROM pub_bcr_RuleBase WHERE pk_billcodebase = '0001ZZ1000000009RZP0';
DELETE FROM pub_bcr_elem WHERE pk_billcodeelem = '0001ZZ1000000009RZP1';
DELETE FROM pub_bcr_elem WHERE pk_billcodeelem = '0001ZZ1000000009RZP2';
DELETE FROM pub_bcr_elem WHERE pk_billcodeelem = '0001ZZ1000000009RZP3';
