package com.speedystone.greendaodemo.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import online.hualin.flymsg.db.ChatHistory;
import online.hualin.flymsg.db.FileHistory;
import online.hualin.flymsg.db.Poetry;

import com.speedystone.greendaodemo.db.ChatHistoryDao;
import com.speedystone.greendaodemo.db.FileHistoryDao;
import com.speedystone.greendaodemo.db.PoetryDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig chatHistoryDaoConfig;
    private final DaoConfig fileHistoryDaoConfig;
    private final DaoConfig poetryDaoConfig;

    private final ChatHistoryDao chatHistoryDao;
    private final FileHistoryDao fileHistoryDao;
    private final PoetryDao poetryDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        chatHistoryDaoConfig = daoConfigMap.get(ChatHistoryDao.class).clone();
        chatHistoryDaoConfig.initIdentityScope(type);

        fileHistoryDaoConfig = daoConfigMap.get(FileHistoryDao.class).clone();
        fileHistoryDaoConfig.initIdentityScope(type);

        poetryDaoConfig = daoConfigMap.get(PoetryDao.class).clone();
        poetryDaoConfig.initIdentityScope(type);

        chatHistoryDao = new ChatHistoryDao(chatHistoryDaoConfig, this);
        fileHistoryDao = new FileHistoryDao(fileHistoryDaoConfig, this);
        poetryDao = new PoetryDao(poetryDaoConfig, this);

        registerDao(ChatHistory.class, chatHistoryDao);
        registerDao(FileHistory.class, fileHistoryDao);
        registerDao(Poetry.class, poetryDao);
    }
    
    public void clear() {
        chatHistoryDaoConfig.clearIdentityScope();
        fileHistoryDaoConfig.clearIdentityScope();
        poetryDaoConfig.clearIdentityScope();
    }

    public ChatHistoryDao getChatHistoryDao() {
        return chatHistoryDao;
    }

    public FileHistoryDao getFileHistoryDao() {
        return fileHistoryDao;
    }

    public PoetryDao getPoetryDao() {
        return poetryDao;
    }

}
